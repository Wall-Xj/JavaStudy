package com.xj.singlegon;

public class Demo03 {
	
	//��̬�ڲ���ʵ�ֵ���ģʽ
	private static class SingletonClassInstance {
		private static final Demo03 demo= new Demo03();
	}
	
	private Demo03(){
		
	}
	
	//����δͬ��������Ч�ʸ�
	public static Demo03 getInstance(){
		return SingletonClassInstance.demo;
	}
	
}
