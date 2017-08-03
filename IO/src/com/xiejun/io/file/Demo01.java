package com.xiejun.io.file;

import java.io.File;
/**
 * ���·�������·������File����
 * 1�����·��
 * 	File(String parant,String child)==>File("E:/aaa","a.txt");
 * 	File(File parent,String child)==>File(new File("E:/aaa"),"a.txt");
 * 2������·��
 * 	File(String name)==>File("E:/aaa/a.txt");
 * @author Administrator
 *
 */
public class Demo01 {
	public static void main(String[] args) {
		System.out.println(File.pathSeparator);
		System.out.println(File.separator);
		
		String filePath="E:"+File.separator+"aaa"+File.separator+"a.txt";
		System.out.println(filePath);
		
		String parentPath="E:"+File.separator+"aaa";
		String fileName="a.txt";
		//���·��
		File file=new File(parentPath,fileName);
		file=new File(new File(parentPath),fileName);
		System.out.println(file.getName());
		System.out.println(file.getPath());
		//����·��
		file=new File(filePath);
		System.out.println(file.getName());
		System.out.println(file.getPath());
		//û���̷����� user.dir����
		file=new File(fileName);
		System.out.println(file.getName());
		System.out.println(file.getAbsolutePath());
		
	}
}
