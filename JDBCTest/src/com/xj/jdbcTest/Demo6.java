package com.xj.jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo6 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		ResultSet set = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://119.23.105.141:3306/jdbcTest?characterEncoding=utf8&useSSL=false", "root",
					"592942092");
			conn.setAutoCommit(false);
			
			ps1 = conn.prepareStatement("insert into t_users(userName,userPwd) values(?,?)");
			ps1.setObject(1, "肯德基");
			ps1.setObject(2, 123);
			ps1.executeUpdate();
			System.out.println("第一条");
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			ps2 = conn.prepareStatement("insert into t_users(userName,userPwd) values(?,?,?)");
			ps2.setObject(1, "麦当劳");
			ps2.setObject(2, 123);
			ps2.executeUpdate();
			System.out.println("第二条");
			
			conn.commit();
			

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			CloseUtil.closeJdbc(set,ps1,ps2,conn);
		}

	}
}
