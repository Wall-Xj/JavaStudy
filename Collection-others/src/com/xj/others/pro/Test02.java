package com.xj.others.pro;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * ʹ��Properties������ļ�
 * ��Դ�����ļ�
 * 
 * 1��	.properties
 * store(OutputStream out, String comments) 
 * store(Writer writer, String comments) 
 * 2��	.xml
 * storeToXML(OutputStream os, String comment)   UTF-8�ַ���
 * storeToXML(OutputStream os, String comment, String encoding) 
 * @author Administrator
 *
 */
public class Test02 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// ��������
		Properties pro = new Properties();
		// �洢
		pro.setProperty("driver", "oracle.jdbc.driver.OracleDriver");
		pro.setProperty("url", "jdbc:oracle:thin:@localhost:1521:orcl");
		pro.setProperty("user", "scott");
		pro.setProperty("pwd", "tiger");
		
		//�洢��f:/others ����·�� �̷���
		File f=new File("f:/others");
		f.mkdir();
		File f1=new File(f,"db.properties");
		f1.createNewFile();
		File f2=new File(f,"db.xml");
		f2.createNewFile();
//		pro.store(new FileOutputStream(f1), "db����");
//		pro.storeToXML(new FileOutputStream(f2),"db����");
		//ʹ�����·��  ��ǰ����
//		pro.store(new FileOutputStream(new File("db.properties")), "db����");
		pro.store(new FileOutputStream(new File("src/com/xj/others/pro/db.properties")), "db����");
		
	}
}
