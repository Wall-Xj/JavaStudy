package com.xj.others.pro;

import java.util.Properties;

/**
 * Properties 资源配置文件的读取 
 * 1、key 与 value 只能为字符串
 * 2、存储与读写
 *   getProperty(String key,String defaultValue) 
 * 	 setProperty(String key, String value)
 * 
 * @author Administrator
 * 
 */
public class Test01 {
	public static void main(String[] args) {
		// 创建对象
		Properties pro = new Properties();
		// 存储
		pro.setProperty("driver", "oracle.jdbc.driver.OracleDriver");
		pro.setProperty("url", "jdbc:oracle:thin:@localhost:1521:orcl");
		pro.setProperty("user", "scott");
		pro.setProperty("pwd", "tiger");
		
		//获取
		String url=pro.getProperty("url", "test");
		System.out.println(url);
	}

}
