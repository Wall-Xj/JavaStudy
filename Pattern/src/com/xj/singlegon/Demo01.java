package com.xj.singlegon;

public class Demo01 {
	//����ģʽ
	private static Demo01 demo01=new Demo01();
	
	private Demo01(){
		
	}
	public static Demo01 getInstance(){
		return demo01;
	}
}
