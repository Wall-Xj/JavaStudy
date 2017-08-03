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
		//匿名内部类(接口式)
		Runnable runnable=new Runnable() {
			
			public void run() {
				
			}
		};
		//匿名内部类（继承式）
		Car car = new Car(){

			public void run() {
				System.out.println("哈哈哈！");
			}
		};
		car.run();
		
		//匿名内部类（ 参数式）
		test02(new Car(){
	
			public void run() {
				System.out.println("参数式匿名内部类");
			}
		});
	}
}

class Car{
	public void run(){
		System.out.println("跑跑跑！");
	}
}