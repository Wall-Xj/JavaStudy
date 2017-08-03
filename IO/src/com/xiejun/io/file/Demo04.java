package com.xiejun.io.file;

import java.io.File;

/**
 * ������ＶĿ¼|�ļ�������
 * 1��listFile()
 * 2���ݹ�
 * @author Administrator
 *
 */
public class Demo04 {
	public static void main(String[] args) {
		String path="E:/aaa";
		File file=new File(path);
		printName(file);
	}
	
	public static void printName(File src){
		if(src==null||!src.exists()){
			return;
		}
		System.out.println(src.getAbsolutePath());
		if(src.isDirectory()){
			for(File sub:src.listFiles()){

				printName(sub);
			}
		}
	}
}
