package com.xj.test;

public class Demo04 {
	public static void main(String[] args) {
		
	}
}

class Outer01{
	
	public void test(){
		int a=3;
		
		class Inner{
			
			int b=4;
//			static int c=6;//�����ڲ�����ֻ�ܶ���Ǿ�̬��Ա
			
			void ttt(){
				System.out.println(b);
				System.out.println(a);
			}
		}
	}
}