package com.xj.others.pro;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * ʹ��Porperties��ȡ�����ļ�
 * ��Դ�����ļ���
 * load(InputStream inStream) 
 * load(Reader reader) 
 * loadFromXML(InputStream in)
 * @author Administrator
 *
 */
public class Test03 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties pro=new Properties();
		//��ȡ����·��
//		pro.load(new FileReader("f:/others/db.properties"));
		//��ȡ���·��
		pro.load(new FileReader("src/com/xj/others/pro/db.properties"));
		
		System.out.println(pro.getProperty("user", "test"));
		
	}
}
