package com.xj.jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo5 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://119.23.105.141:3306/jdbcTest?characterEncoding=utf8&useSSL=false", "root",
					"592942092");
			conn.setAutoCommit(false);
			stmt=conn.createStatement();
			for(int i=0;i<3;i++)
			{
				stmt.addBatch("insert into t_users(userName,userPwd,realName,register) values('test"+i+"',111,'',now())");
			}
			stmt.executeBatch();
			conn.commit();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			CloseUtil.closeJdbc(set,stmt,conn);
		}

	}
}
