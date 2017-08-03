package com.xj.jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Demo01 {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			long start = System.currentTimeMillis();
			conn = DriverManager.getConnection("jdbc:mysql://119.23.105.141:3306/jdbcTest?useSSL=false", "root",
					"592942092");
			long end = System.currentTimeMillis();

			System.out.println("建立连接耗时：" + (end - start) + "ms");
			System.out.println(conn);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			CloseUtil.closeJdbc(conn);
		}
	}
}
