package com.xj.sorm.core;
/**
 * 负责查询（对外提供服务的核心类）
 * @author WanYin
 *
 */

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xj.sorm.bean.ColumnInfo;
import com.xj.sorm.bean.TableInfo;
import com.xj.sorm.utils.JDBCUtils;
import com.xj.sorm.utils.ReflectUtils;
@SuppressWarnings("all")
public abstract class Query implements Cloneable {
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	/**
	 * 查询模版方法
	 * @param sql
	 * @param params
	 * @param clazz
	 * @param back
	 * @return
	 */
	 public Object executeQueryTemplate(String sql, Object[] params,Class clazz,CallBack back){
			Connection conn = DBManager.getConn();
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				ps = conn.prepareStatement(sql);
				// 给sql设参
				JDBCUtils.handleParams(ps, params);
				rs = ps.executeQuery();
				return back.doExecute(conn, ps, rs);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			} finally {
				DBManager.close(ps, conn);
			}
	 }
	
	/**
	 * 执行DML语句 
	 * @param sql
	 * @param params
	 * @return 受影响的行数
	 */
	public int executeDML(String sql, Object[] params) {
		Connection conn = DBManager.getConn();
		int count = 0;
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			// 给sql设参
			JDBCUtils.handleParams(ps, params);
			System.out.println(ps);
			count = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(ps, conn);
		}

		return count;
	}

	/**
	 * 将对象存储到数据库中 
	 * @param obj 需要存的对象
	 */
	public void insert(Object obj) {
		// obj-->表中。 insert into 表名 (id,uname,pwd) values (?,?,?)
		Class c = obj.getClass();
		List<Object> params = new ArrayList<Object>(); // 存储sql的参数对象
		TableInfo tableInfo = TableContext.poClassTableMap.get(c);
		StringBuilder sql = new StringBuilder("insert into " + tableInfo.getTname() + " (");
		int countNotNullField = 0; // 计算不为null的属性值
		Field[] fs = c.getDeclaredFields();
		for (Field f : fs) {
			String fieldName = f.getName();
			Object fieldValue = ReflectUtils.invokeGet(fieldName, obj);

			if (fieldValue != null) {
				countNotNullField++;
				sql.append(fieldName + ",");
				params.add(fieldValue);
			}
		}

		sql.setCharAt(sql.length() - 1, ')');
		sql.append(" values (");
		for (int i = 0; i < countNotNullField; i++) {
			sql.append("?,");
		}
		sql.setCharAt(sql.length() - 1, ')');

		executeDML(sql.toString(), params.toArray());
	}

	/**
	 * 删除类对应的表中的数据 
	 * @param clazz  对应表的类
	 * @param id 主键
	 */
	public void delete(Class clazz, Object id) {
		// Emp.class,2-->delete from emp where id=2
		// 通过Class对象找TableInfo
		TableInfo tableInfo = TableContext.poClassTableMap.get(clazz);
		// 获得主键
		ColumnInfo onlyPriKey = tableInfo.getOnlyPriKey();

		String sql = "delete from " + tableInfo.getTname() + " where " + onlyPriKey.getName() + "=? ";

		executeDML(sql, new Object[] { id });
	}

	/**
	 * 删除对象对应表中的数据 
	 * @param obj
	 */
	public void delete(Object obj) {
		Class c = obj.getClass();
		TableInfo tableInfo = TableContext.poClassTableMap.get(c);
		ColumnInfo onlyPriKey = tableInfo.getOnlyPriKey(); // 主键

		// 通过反射机制，调用属性对应的get方法或set方法
		Object priKeyValue = ReflectUtils.invokeGet(onlyPriKey.getName(), obj);

		delete(c, priKeyValue);
	}

	/**
	 * 更新对象对应的数据，只更新指定字段 
	 * @param obj 更新的对象
	 * @param fieldNames 更新的属性列表
	 * @return 影响的行数
	 */
	public int update(Object obj, String[] fieldNames) {
		// obj{"uanme","pwd"}-->update 表名 set uname=?,pwd=? where id=?
		Class c = obj.getClass();
		List<Object> params = new ArrayList<Object>(); // 存储sql的参数对象
		TableInfo tableInfo = TableContext.poClassTableMap.get(c);
		ColumnInfo priKey = tableInfo.getOnlyPriKey(); // 获得唯一的主键
		StringBuilder sql = new StringBuilder("update " + tableInfo.getTname() + " set ");

		for (String fname : fieldNames) {
			Object fvalue = ReflectUtils.invokeGet(fname, obj);
			params.add(fvalue);
			sql.append(fname + "=?,");
		}
		sql.setCharAt(sql.length() - 1, ' ');
		sql.append(" where ");
		sql.append(priKey.getName() + "=? ");

		params.add(ReflectUtils.invokeGet(priKey.getName(), obj)); // 主键的值

		return executeDML(sql.toString(), params.toArray());
	}

	/**
	 * 查询返回多行记录，并将记录封装在clazz对应的对象中 
	 * @param sql
	 * @param clazz
	 * @param params
	 * @return
	 */
	public List queryRows(String sql, Class clazz, Object[] params) {
		
		return (List)executeQueryTemplate(sql, params, clazz, new CallBack() {
			
			@Override
			public Object doExecute(Connection conn, PreparedStatement ps, ResultSet rs) {
				List list=null;
				try {
					ResultSetMetaData metaData = rs.getMetaData();
					// 多行
					while (rs.next()) {
						if (list == null) {
							list = new ArrayList();
						}
						Object rowObj = clazz.newInstance(); // 调用javabean的无参构造器

						// 多列 select username ,pwd,age from user where id>? and age>18
						for (int i = 0; i < metaData.getColumnCount(); i++) {
							String columnName = metaData.getColumnLabel(i + 1); // username
							Object columnValue = rs.getObject(i + 1);

							// 调用rowObj对象的setUsername(String uname)方法，将columnValue的值设置进去
							ReflectUtils.invokeSet(rowObj, columnName, columnValue);
						}

						list.add(rowObj);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return list;
			}
		});
	}

	/**
	 * 查询返回单记录，并将记录封装在clazz对应的对象中 
	 * @param sql
	 * @param clazz
	 * @param params
	 * @return
	 */
	public Object queryUniqueRow(String sql, Class clazz, Object[] params) {
		List list = queryRows(sql, clazz, params);
		return (list == null && list.size() > 0) ? null : list.get(0);
	}

	/**
	 * 查询一个值 
	 * @param sql
	 * @param params
	 * @return
	 */
	public Object queryValue(String sql, Object[] params) {
		
		return executeQueryTemplate(sql, params, null, new CallBack() {
			
			@Override
			public Object doExecute(Connection conn, PreparedStatement ps, ResultSet rs) {
				Object value = null; // 存储查询结果的对象
				try {
					while (rs.next()) {
						value = rs.getObject(1);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return value;
			}
		});

	}

	/**
	 * 查询一个数字 
	 * @param sql
	 * @param params
	 * @return
	 */
	public Number queryNumber(String sql, Object[] params) {
		return (Number) queryValue(sql, params);
	}

	/**
	 * 分页查询
	 * @param pageNum
	 * @param size
	 * @return
	 */
	public abstract List queryPagenate(int pageNum,int size);
	
}
