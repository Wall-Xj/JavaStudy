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
		final static int d=4;//��Ա�ڲ��಻���о�̬��Ա����������Ϊfinal
//		final static Date d2=new Date();//����ֻ���Ǳ���������ȷ��ֵ�ĳ������ʽ
		
		void test(){
			System.out.println(a);
			System.out.println("�ڲ������"+this);//��Ա�ڲ���Ĵ����������ȴ����ⲿ��
			System.out.println("�ⲿ�����"+Outer03.this);//�������ⲿ�����
		}
	}
}