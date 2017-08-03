package com.xj.prototype;

import java.util.Date;

public class Client02 {
	public static void main(String[] args) throws Exception {
		
		Date d=new Date(3213123021L);
		Sheep02 s1=new Sheep02("∂‡¿Ô",d);
		Sheep02 s2=(Sheep02)s1.clone();
		
		
		System.out.println(s1);
		System.out.println(s1.getName());
		System.out.println(s1.getBirthday());
		
		d.setTime(43134131232L);
		System.out.println(s1.getBirthday());
		
		System.out.println(s2);
		System.out.println(s2.getName());
		System.out.println(s2.getBirthday());
		
		
		
	}
}
