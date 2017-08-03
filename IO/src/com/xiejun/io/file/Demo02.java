package com.xiejun.io.file;

import java.io.File;
import java.io.IOException;
/**
 * 常用方法：
 * 1、文件名
 * 	getName()	文件名、路径名
 * 	getPath()	路径名
 * 	getAbsoluteFile()	绝对路径锁对应的File对象
 * 	getAbsolutePath()	绝对路径名
 * 	getParent()	父目录，相对路径的父目录，可能为null 如，删除本身后的结果
 * 2、判断信息
 * 	exists()
 * 	canWrite()
 * 	canRead()
 * 	isFile()
 * 	isDirectory()
 * 	isAbsolute():消除平台差异，ie以盘符开头，其他以/开头
 * 3、长度 字节数	不能读取文件夹的长度
 * 	length()
 * 4、创建、删除
 * 	createNewFile()	你存在 创建新文件
 * 	delete()	删除文件
 * 	static createTempFile(前缀3个字节长，后缀默认.temp) 默认临时空间
 * 	static createTempFile(前缀3个字节长，后缀默认.temp,目录) 
 * 	deleteOnExit() 退出虚拟机删除，常用于删除临时文件
 * 	
 * @author Administrator
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		//test2();
		try {
			test3();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("文件操作失败");
		}
	}
	//创建删除文件
	public static void test3() throws IOException{
		String path="E:/aaa/1.txt";
		File src=new File(path);
		if(!src.exists()){
			boolean flag=src.createNewFile();
			System.out.println(flag?"成功":"失败");
		}
		File temp=File.createTempFile("tes", ".temp",new File("E:/aaa"));
		try {
			Thread.sleep(3000);
			temp.deleteOnExit();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	//2、判断信息
	public static void test2(){
		String path="E:"+File.separator+"aaa"+File.separator+"a.txt";
		//String path="E:"+File.separator+"aaa";
		//String path="a.txt";
		File src=new File(path);
		System.out.println("文件是否存在："+src.exists());
		System.out.println("文件是否可写："+src.canRead());
		if(src.isFile()){
			System.out.println("文件");
		}else if(src.isDirectory()){
			//没有真是存在的默认为文件夹
			System.out.println("文件夹");
		}else{
			System.out.println("文件不存在");
		}	
		System.out.println(src.isAbsolute());
		System.out.println("长度为："+src.length());
		
	}
	//1、名称
	public static void test1(){
		String filePath="E:"+File.separator+"aaa"+File.separator+"a.txt";
		//建立联系
		File file=new File(filePath);
		file=new File("a.txt");
		System.out.println(file.getName());//返回名称
		System.out.println(file.getPath());//如果是绝对路径，返回完整路径，否则返回相对路径
		System.out.println(file.getAbsolutePath());//返回绝对路径
		System.out.println(file.getParent());//返回上级目录，如果是相对，返回null
		
	}
}
