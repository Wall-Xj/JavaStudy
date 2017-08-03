package com.xj.others.pro;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * 使用Porperties读取配置文件
 * 资源配置文件：
 * load(InputStream inStream) 
 * load(Reader reader) 
 * loadFromXML(InputStream in)
 * @author Administrator
 *
 */
public class Test03 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties pro=new Properties();
		//读取绝对路径
//		pro.load(new FileReader("f:/others/db.properties"));
		//读取相对路径
		pro.load(new FileReader("src/com/xj/others/pro/db.properties"));
		
		System.out.println(pro.getProperty("user", "test"));
		
	}
}
