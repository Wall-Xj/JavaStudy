package com.xj.sorm.core;
/**
 * �����ѯ�������ṩ����ĺ����ࣩ
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
	 * ��ѯģ�淽��
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
				// ��sql���
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
	 * ִ��DML��� 
	 * @param sql
	 * @param params
	 * @return ��Ӱ�������
	 */
	public int executeDML(String sql, Object[] params) {
		Connection conn = DBManager.getConn();
		int count = 0;
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			// ��sql���
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
	 * ������洢�����ݿ��� 
	 * @param obj ��Ҫ��Ķ���
	 */
	public void insert(Object obj) {
		// obj-->���С� insert into ���� (id,uname,pwd) values (?,?,?)
		Class c = obj.getClass();
		List<Object> params = new ArrayList<Object>(); // �洢sql�Ĳ�������
		TableInfo tableInfo = TableContext.poClassTableMap.get(c);
		StringBuilder sql = new StringBuilder("insert into " + tableInfo.getTname() + " (");
		int countNotNullField = 0; // ���㲻Ϊnull������ֵ
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
	 * ɾ�����Ӧ�ı��е����� 
	 * @param clazz  ��Ӧ�����
	 * @param id ����
	 */
	public void delete(Class clazz, Object id) {
		// Emp.class,2-->delete from emp where id=2
		// ͨ��Class������TableInfo
		TableInfo tableInfo = TableContext.poClassTableMap.get(clazz);
		// �������
		ColumnInfo onlyPriKey = tableInfo.getOnlyPriKey();

		String sql = "delete from " + tableInfo.getTname() + " where " + onlyPriKey.getName() + "=? ";

		executeDML(sql, new Object[] { id });
	}

	/**
	 * ɾ�������Ӧ���е����� 
	 * @param obj
	 */
	public void delete(Object obj) {
		Class c = obj.getClass();
		TableInfo tableInfo = TableContext.poClassTableMap.get(c);
		ColumnInfo onlyPriKey = tableInfo.getOnlyPriKey(); // ����

		// ͨ��������ƣ��������Զ�Ӧ��get������set����
		Object priKeyValue = ReflectUtils.invokeGet(onlyPriKey.getName(), obj);

		delete(c, priKeyValue);
	}

	/**
	 * ���¶����Ӧ�����ݣ�ֻ����ָ���ֶ� 
	 * @param obj ���µĶ���
	 * @param fieldNames ���µ������б�
	 * @return Ӱ�������
	 */
	public int update(Object obj, String[] fieldNames) {
		// obj{"uanme","pwd"}-->update ���� set uname=?,pwd=? where id=?
		Class c = obj.getClass();
		List<Object> params = new ArrayList<Object>(); // �洢sql�Ĳ�������
		TableInfo tableInfo = TableContext.poClassTableMap.get(c);
		ColumnInfo priKey = tableInfo.getOnlyPriKey(); // ���Ψһ������
		StringBuilder sql = new StringBuilder("update " + tableInfo.getTname() + " set ");

		for (String fname : fieldNames) {
			Object fvalue = ReflectUtils.invokeGet(fname, obj);
			params.add(fvalue);
			sql.append(fname + "=?,");
		}
		sql.setCharAt(sql.length() - 1, ' ');
		sql.append(" where ");
		sql.append(priKey.getName() + "=? ");

		params.add(ReflectUtils.invokeGet(priKey.getName(), obj)); // ������ֵ

		return executeDML(sql.toString(), params.toArray());
	}

	/**
	 * ��ѯ���ض��м�¼��������¼��װ��clazz��Ӧ�Ķ����� 
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
					// ����
					while (rs.next()) {
						if (list == null) {
							list = new ArrayList();
						}
						Object rowObj = clazz.newInstance(); // ����javabean���޲ι�����

						// ���� select username ,pwd,age from user where id>? and age>18
						for (int i = 0; i < metaData.getColumnCount(); i++) {
							String columnName = metaData.getColumnLabel(i + 1); // username
							Object columnValue = rs.getObject(i + 1);

							// ����rowObj�����setUsername(String uname)��������columnValue��ֵ���ý�ȥ
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
	 * ��ѯ���ص���¼��������¼��װ��clazz��Ӧ�Ķ����� 
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
	 * ��ѯһ��ֵ 
	 * @param sql
	 * @param params
	 * @return
	 */
	public Object queryValue(String sql, Object[] params) {
		
		return executeQueryTemplate(sql, params, null, new CallBack() {
			
			@Override
			public Object doExecute(Connection conn, PreparedStatement ps, ResultSet rs) {
				Object value = null; // �洢��ѯ����Ķ���
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
	 * ��ѯһ������ 
	 * @param sql
	 * @param params
	 * @return
	 */
	public Number queryNumber(String sql, Object[] params) {
		return (Number) queryValue(sql, params);
	}

	/**
	 * ��ҳ��ѯ
	 * @param pageNum
	 * @param size
	 * @return
	 */
	public abstract List queryPagenate(int pageNum,int size);
	
}
