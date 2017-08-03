package com.xj.jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Demo03 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://119.23.105.141:3306/jdbcTest?characterEncoding=utf8&useSSL=false", "root",
					"592942092");
			String sql = "insert into t_users(userName,userPwd,realName,register) values(?,?,?,?)";
			ps = conn.prepareStatement(sql);
			// ps.setString(1, "admin");
			// ps.setString(2, "123456");
			// ps.setString(3, "占三");
			// ps.setDate(4, new java.sql.Date(System.currentTimeMillis()));
			ps.setObject(1, "test2");
			ps.setObject(2, "123456");
			ps.setObject(3, "李四");
			ps.setObject(4, new java.sql.Date(System.currentTimeMillis()));

			ps.execute();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CloseUtil.closeJdbc(ps, conn);
		}

	}
}
