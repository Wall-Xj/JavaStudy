package com.xiejun.io.convert;

import java.io.UnsupportedEncodingException;

public class Demo01 {
	public static void main(String[] args) {
		String str="中国";
		byte[] data=str.getBytes();
		System.out.println(new String(data,0,3));
	}
	
	public static void test01()throws UnsupportedEncodingException {
		//解码byte==>char
		String str="中国";
		//编码char-->byte
		byte[] data=str.getBytes();
		//编码与解码字符集统一
		System.out.println(new String(data));
		data=str.getBytes("utf-8");
		//不统一出现乱码
		System.out.println(new String(data));
		
		//编码
		byte[] data2="中国".getBytes("utf-8");
		//解码
		str=new String(data2,"utf-8");
		System.out.println(str);
	}
}
