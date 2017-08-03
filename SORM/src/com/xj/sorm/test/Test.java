package com.xj.sorm.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.xj.po.Emp;
import com.xj.sorm.core.DBManager;
import com.xj.sorm.core.MySqlQuery;
import com.xj.sorm.core.Query;
import com.xj.sorm.core.QueryFactory;

public class Test {
	
	public static void test01(){
		Query q = QueryFactory.createQuery();
		String sql="select * from emp where gender=? and salary>?";
		List<Emp>list=q.queryRows(sql, Emp.class, new Object[]{1,2000});
		for(Emp e : list){
			System.out.println(e.getName()+"--"+e.getGender()+"--"+e.getSalary());
		}
	}
	
	
	public static void main(String[] args) {
		
		long a=System.currentTimeMillis();
		for(int i=0;i<100;i++){
			test01();
		}
		long b=System.currentTimeMillis();
		System.out.println(b-a);
		
	}
}
