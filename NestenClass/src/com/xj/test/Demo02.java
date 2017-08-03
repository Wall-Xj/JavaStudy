package com.xj.test;

import java.util.Date;

public class Demo02 {
	public static void main(String[] args) {

		Outer03 out=new Outer03();
		Outer03.InnerClass ic=out.new InnerClass();
		ic.test();
	}
}


class Outer03{
	private int a=3;
	int b=10;
	
	class InnerClass{
		int c=1;
		final static int d=4;//成员内部类不能有静态成员，除非声明为final
//		final static Date d2=new Date();//并且只能是编译器可以确定值的常量表达式
		
		void test(){
			System.out.println(a);
			System.out.println("内部类对象："+this);//成员内部类的创建，必须先创建外部类
			System.out.println("外部类对象："+Outer03.this);//引用了外部类对象
		}
	}
}