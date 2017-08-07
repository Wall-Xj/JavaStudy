package com.xj.utils;

import java.sql.Connection;

public class DBManager {
	private static DBConnPool pool = null;

	public static Connection getConn() {
		if (pool == null) {
			pool = new DBConnPool();
		}
		return pool.getConn();
	}

	public static <T extends AutoCloseable> void close(T... ts) {
		for (AutoCloseable t : ts) {
			try {
				if (t != null) {
					if (t instanceof Connection) {
						if (pool == null) {
							pool = new DBConnPool();
						}
						pool.close((Connection) t);
					} else {
						t.close();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
