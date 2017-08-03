package com.xj.sorm.core;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.xj.sorm.bean.Configuration;
import com.xj.sorm.pool.DBConnPool;

/**
 * ����������Ϣ��ά�����Ӷ���Ĺ���(�������ӳع���)
 * 
 * @author Administrator
 *
 */
public class DBManager {
	/**
	 * ������Ϣ
	 */
	private static Configuration conf;
	/**
	 * ���ӳض���
	 */
	private static DBConnPool pool = null;

	static { // ��̬�����
		Properties pros = new Properties();
		try {
			pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		conf = new Configuration();
		conf.setDriver(pros.getProperty("driver"));
		conf.setPoPackage(pros.getProperty("poPackage"));
		conf.setPwd(pros.getProperty("pwd"));
		conf.setSrcPath(pros.getProperty("srcPath"));
		conf.setUrl(pros.getProperty("url"));
		conf.setUser(pros.getProperty("user"));
		conf.setUsingDB(pros.getProperty("usingDB"));
		conf.setQueryClass(pros.getProperty("queryClass"));
		conf.setPoolMinSize(Integer.parseInt(pros.getProperty("poolMinSize")));
		conf.setPoolMaxSize(Integer.parseInt(pros.getProperty("poolMaxSize")));

		System.out.println(TableContext.class);
	}

	public static Connection getConn() {
		if (pool == null) {
			pool = new DBConnPool();
		}
		return pool.getConnection();
	}

	public static Connection createConn() {
		try {
			Class.forName(conf.getDriver());
			return DriverManager.getConnection(conf.getUrl(), conf.getUser(), conf.getPwd());
			// ֱ�ӽ������ӣ������������ӳش������Ч�ʣ�����
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
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

	/**
	 * ����Configuration����
	 * 
	 * @return
	 */
	public static Configuration getConf() {
		return conf;
	}
}
