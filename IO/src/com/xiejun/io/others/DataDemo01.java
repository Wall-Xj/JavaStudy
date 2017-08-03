package com.xiejun.io.others;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataDemo01 {
	public static void main(String[] args) throws IOException {
		//write("e:/aaa/3.txt");
		read("e:/aaa/3.txt");
	}
	
	public static void read(String srcPath) throws IOException{
		File src=new File(srcPath);
		DataInputStream dis=new DataInputStream(
				new BufferedInputStream(
						new FileInputStream(src)
						)
				);
		long num=dis.readLong();
		double point=dis.readDouble();
		String str=dis.readUTF();
		dis.close();
		System.out.println(num);
		System.out.println(point);
		System.out.println(str);
	}
	
	public static void write(String destPath) throws IOException{
		File dest=new File(destPath);
		String str="浙江离奇土豪开错车";
		long num=1000L;
		double point=12.3;
		DataOutputStream dos=new DataOutputStream(
					new BufferedOutputStream(
							new FileOutputStream(dest)
							)
				);
		dos.writeLong(num);
		dos.writeDouble(point);
		dos.writeUTF(str);
		dos.flush();
		dos.close();
	}
}
