package com.xj.others.pro;

import java.io.IOException;
import java.util.Properties;

/**
 * ʹ�������·����ȡ�����ļ�
 * bin
 * @author Administrator
 *
 */
public class Test04 {
	public static void main(String[] args) throws IOException {
		Properties pro=new Properties();
		//�����·�� /bin
//		pro.load(Test04.class.getResourceAsStream("/com/xj/others/pro/db.properties"));
		pro.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("com/xj/others/pro/db.properties"));
		System.out.println(pro.getProperty("user","test"));
	}
}
