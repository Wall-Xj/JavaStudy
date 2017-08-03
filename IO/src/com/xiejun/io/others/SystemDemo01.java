package com.xiejun.io.others;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class SystemDemo01 {

	/**
	 * 1、System.in
	 * 2、System.out
	 * 2、System.err
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		//重定向
		System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("e:/aaa/1.txt")),true));
		System.out.println("sd");
		System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)),true));
		System.out.println("sd");
	}
	
	public static void test01() throws FileNotFoundException{
		InputStream is=System.in;
		is=new 	BufferedInputStream(new FileInputStream("e:/aaa/1.txt"));
		Scanner sc=new Scanner(is);
		System.out.println("请输入：");
		System.out.println(sc.nextLine());
	}

}
