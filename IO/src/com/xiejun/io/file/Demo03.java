package com.xiejun.io.file;

import java.io.File;
import java.io.FilenameFilter;

/**
 * 5、操作目录
 * 	mkdir()	创建目录，必须确保父目录的存在，否则创建失败
 * 	mkdirs() 创建目录，如果父目录链不存在一同创建
 * 	list() 文件|目录字符串形式
 * 	listFiles()
 * 	static listRoots() 根目录
 * @author Administrator
 *
 */
public class Demo03 {
	public static void main(String[] args) {
		String path="E:/aaa";
		File src=new File(path);//文件夹
		if(src.isDirectory()){//存在并且为目录
			System.out.println("=====子目录|文件名");
			String[] subNames=src.list();
			for(String name : subNames){
				System.out.println(name);
			}
			System.out.println("=====子目录|文件File对象===");
			File[] subFiles=src.listFiles();
			for(File temp:subFiles){
				System.out.println(temp.getAbsolutePath());
			}
			System.out.println("=====子目录|.txt===");
			//命令设计模式
			subFiles=src.listFiles(new FilenameFilter(){

				@Override
				public boolean accept(File dir, String name) {
					//System.out.println(dir.getAbsolutePath());
					return new File(dir,name).isFile()&& name.endsWith(".txt");
				}
				
			});
			for(File temp:subFiles){
				System.out.println(temp.getAbsolutePath());
			}
		}
		
	}
	
	public static void test1(){
		String path="E:/aaa/parent/test";
		File src=new File(path);
		//src.mkdir();
		src.mkdirs();
	}
}
