package com.xj.jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo4 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet set = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://119.23.105.141:3306/jdbcTest?characterEncoding=utf8&useSSL=false", "root",
					"592942092");
			String sql = "select Id,userName,userPwd,realName,register from t_users where Id>=?";
			ps = conn.prepareStatement(sql);
			ps.setObject(1, 1);
			set = ps.executeQuery();
			while (set.next()) {
				System.out.println(set.getInt(1) + "--" + set.getString(2) + "--" + set.getString(3) + "--"
						+ set.getString(4) + "--" + set.getString(5));
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			CloseUtil.closeJdbc(set,ps,conn);
		}

	}
}
