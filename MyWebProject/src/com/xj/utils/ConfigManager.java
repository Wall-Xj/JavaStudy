package com.xj.utils;

import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
	private static Configuration conf;
	
	static {
		Properties prop=new Properties();
		try {
			prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		conf=new Configuration();
		conf.setDriver(prop.getProperty("driver"));
		conf.setPoolMaxSize(Integer.parseInt(prop.getProperty("poolMaxSize")));
		conf.setPoolMixSize(Integer.parseInt(prop.getProperty("poolMinSize")));
		conf.setPwd(prop.getProperty("pwd"));
		conf.setUrl(prop.getProperty("url"));
		conf.setUser(prop.getProperty("user"));
		conf.setUserDB(prop.getProperty("usingDB"));
	}
	
	public static Configuration getConf() {
		return conf;
	}
}
