package com.xj.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBConnPool {
	private List<Connection> pool;

	private static final int POOL_MAX_SIZE = ConfigManager.getConf().getPoolMaxSize();

	private static final int POOL_MIN_SIZE = ConfigManager.getConf().getPoolMixSize();

	public void initPool() {
		if (pool == null) {
			pool = new ArrayList<Connection>();
		}
		while (pool.size() < POOL_MIN_SIZE) {
			pool.add(createConn());
		}
	}
	
	public synchronized Connection getConn() {
		int index=pool.size()-1;
		Connection conn=pool.get(index);
		pool.remove(index);
		return conn;
	}
	
	public synchronized void close(Connection conn) {
		if(pool.size()>=POOL_MAX_SIZE) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			pool.add(conn);
		}
	}

	private Connection createConn() {
		try {
			Class.forName(ConfigManager.getConf().getDriver());
			return DriverManager.getConnection(ConfigManager.getConf().getUrl(), ConfigManager.getConf().getUser(),
					ConfigManager.getConf().getPwd());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public DBConnPool() {
		initPool();
	}

}
