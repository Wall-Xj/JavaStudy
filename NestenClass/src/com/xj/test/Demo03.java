package com.xj.test;

import com.xj.test.Outer02.StaticInnerClass;

public class Demo03 {
	 public static void main(String[] args) {
		Outer02.StaticInnerClass osic = new Outer02.StaticInnerClass();
		StaticInnerClass sic=new StaticInnerClass();//import com.xj.test.Outer02.StaticInnerClass; 
		
	}
}

class Outer02{
	int c=5;
	static int d=10;
	 static class StaticInnerClass{
		int a=3;
		static int b=8;
		
		void ttt(){
			StaticInnerClass sic=new StaticInnerClass();
		}
		
		public void test(){
			System.out.println(d);
//			System.out.println(c);//静态内部类中不能调用外部类的普通成员。只能调用静态成员
		}
	}
}