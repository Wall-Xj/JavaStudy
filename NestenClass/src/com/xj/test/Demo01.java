package com.xj.test;

public class Demo01 {
	//��̬�ڲ���
	private static class StaticNestedClass{
		
	}
	
	//��ͨ�ڲ��ࣨ��Ա�ڲ��ࣩ
	private class FieldInnerClass{
		
	}
	
	void sayHello(){
		//�����ڲ��ࣨ�ֲ��ڲ��ࣩ
		class LocalClass{
			
		}
		//�����ڲ���
		Runnable runnable = 
			new Runnable() {
				public void run() {
					
				}
		};
	}
	
}
