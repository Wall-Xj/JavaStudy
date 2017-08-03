package com.xj.gen01;

/**
 * 自定义泛型类的使用，
 * 在声明时指定类型
 * 不能为基本类型，只能为引用类型
 * @author Administrator
 *
 */
public class Simple {
	public static void main(String[] args) {
		Student<Integer>stu=new Student<Integer>();
		stu.setJavase(123);
		Integer score=stu.getJavase();
		System.out.println(score);
	}
}
