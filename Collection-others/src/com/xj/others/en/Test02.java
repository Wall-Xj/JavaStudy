package com.xj.others.en;

import java.util.StringTokenizer;

public class Test02 {
	public static void main(String[] args) {
		String emailStr="jxy@163.com;jxy@qq.com;jxy@sina.com";
		StringTokenizer token=new StringTokenizer(emailStr,";");
		while(token.hasMoreElements()){
			System.out.println(token.nextElement());
		}
	}
}
