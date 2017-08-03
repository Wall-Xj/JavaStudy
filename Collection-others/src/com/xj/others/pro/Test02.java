package com.xj.others.pro;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 使用Properties输出到文件
 * 资源配置文件
 * 
 * 1、	.properties
 * store(OutputStream out, String comments) 
 * store(Writer writer, String comments) 
 * 2、	.xml
 * storeToXML(OutputStream os, String comment)   UTF-8字符集
 * storeToXML(OutputStream os, String comment, String encoding) 
 * @author Administrator
 *
 */
public class Test02 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// 创建对象
		Properties pro = new Properties();
		// 存储
		pro.setProperty("driver", "oracle.jdbc.driver.OracleDriver");
		pro.setProperty("url", "jdbc:oracle:thin:@localhost:1521:orcl");
		pro.setProperty("user", "scott");
		pro.setProperty("pwd", "tiger");
		
		//存储到f:/others 绝对路径 盘符：
		File f=new File("f:/others");
		f.mkdir();
		File f1=new File(f,"db.properties");
		f1.createNewFile();
		File f2=new File(f,"db.xml");
		f2.createNewFile();
//		pro.store(new FileOutputStream(f1), "db配置");
//		pro.storeToXML(new FileOutputStream(f2),"db配置");
		//使用相对路径  当前工程
//		pro.store(new FileOutputStream(new File("db.properties")), "db配置");
		pro.store(new FileOutputStream(new File("src/com/xj/others/pro/db.properties")), "db配置");
		
	}
}
