package com.xj.jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo2 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://119.23.105.141:3306/jdbcTest?characterEncoding=utf8&useSSL=false", "root",
					"592942092");
			stmt = conn.createStatement();
			String sql = "insert into t_users(Name,Gender,Age,Address) values('张三',1,20,'浙江杭州')";
			stmt.execute(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			CloseUtil.closeJdbc(stmt, conn);
		}
	}
}
