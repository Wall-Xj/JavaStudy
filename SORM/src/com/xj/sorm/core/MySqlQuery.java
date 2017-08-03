package com.xj.sorm.core;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import com.xj.po.Emp;
import com.xj.sorm.bean.ColumnInfo;
import com.xj.sorm.bean.TableInfo;
import com.xj.sorm.utils.JDBCUtils;
import com.xj.sorm.utils.ReflectUtils;

public class MySqlQuery extends Query {

	@Override
	public List queryPagenate(int pageNum, int size) {
		return null;
	}
	
	public static void testInsert(){
		Emp e=new Emp();
		e.setBirthday(new java.sql.Date(System.currentTimeMillis()));
		e.setBonus(500d);
		e.setDepartment(1);
		e.setGender(1);
		e.setName("jack");
		e.setSalary(4500d);
		new MySqlQuery().insert(e);
	}
	
	public static void testQueryRows(){
		String sql="select * from emp where gender=? and salary>?";
		List<Emp>list=new MySqlQuery().queryRows(sql, Emp.class, new Object[]{1,2000});
		for(Emp e : list){
			System.out.println(e.getName()+"--"+e.getGender()+"--"+e.getSalary());
		}
	}
	
	public static void main(String[] args) {
//		testQueryRows();
	}
	
}
