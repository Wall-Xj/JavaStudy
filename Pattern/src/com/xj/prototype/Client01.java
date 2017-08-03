package com.xj.prototype;

import java.util.Date;
/**
 * 原型模式
 * @author WanYin
 *
 */
public class Client01 {
	public static void main(String[] args) throws Exception {
		
		Date d=new Date(3213123021L);
		Sheep s1=new Sheep("多里",d);
		Sheep s2=(Sheep)s1.clone();
		
		
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
