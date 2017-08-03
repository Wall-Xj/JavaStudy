package com.xj.others.pro;

import java.util.Properties;

/**
 * Properties ��Դ�����ļ��Ķ�ȡ 
 * 1��key �� value ֻ��Ϊ�ַ���
 * 2���洢���д
 *   getProperty(String key,String defaultValue) 
 * 	 setProperty(String key, String value)
 * 
 * @author Administrator
 * 
 */
public class Test01 {
	public static void main(String[] args) {
		// ��������
		Properties pro = new Properties();
		// �洢
		pro.setProperty("driver", "oracle.jdbc.driver.OracleDriver");
		pro.setProperty("url", "jdbc:oracle:thin:@localhost:1521:orcl");
		pro.setProperty("user", "scott");
		pro.setProperty("pwd", "tiger");
		
		//��ȡ
		String url=pro.getProperty("url", "test");
		System.out.println(url);
	}

}
