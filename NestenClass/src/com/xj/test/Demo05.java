package com.xj.test;

public class Demo05 {
	public static void main(String[] args) {
		Outer05 out = new Outer05();
		out.test();
	}
}

class Outer05{
	
	public void test02(Car car){
		car.run();
	}
	
	
	public void test(){
		//�����ڲ���(�ӿ�ʽ)
		Runnable runnable=new Runnable() {
			
			public void run() {
				
			}
		};
		//�����ڲ��ࣨ�̳�ʽ��
		Car car = new Car(){

			public void run() {
				System.out.println("��������");
			}
		};
		car.run();
		
		//�����ڲ��ࣨ ����ʽ��
		test02(new Car(){
	
			public void run() {
				System.out.println("����ʽ�����ڲ���");
			}
		});
	}
}

class Car{
	public void run(){
		System.out.println("�����ܣ�");
	}
}