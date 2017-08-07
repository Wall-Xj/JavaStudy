package com.xj.utils;

public class Configuration {
	private String userDB;
	private String driver;
	private String url;
	private String user;
	private String pwd;
	private int poolMixSize;
	private int poolMaxSize;
	public Configuration(String userDB, String driver, String url, String user, String pwd, int poolMixSize,
			int poolMaxSize) {
		super();
		this.userDB = userDB;
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.pwd = pwd;
		this.poolMixSize = poolMixSize;
		this.poolMaxSize = poolMaxSize;
	}
	public Configuration() {
		super();
	
	}
	public String getUserDB() {
		return userDB;
	}
	public void setUserDB(String userDB) {
		this.userDB = userDB;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getPoolMixSize() {
		return poolMixSize;
	}
	public void setPoolMixSize(int poolMixSize) {
		this.poolMixSize = poolMixSize;
	}
	public int getPoolMaxSize() {
		return poolMaxSize;
	}
	public void setPoolMaxSize(int poolMaxSize) {
		this.poolMaxSize = poolMaxSize;
	}
	
}
