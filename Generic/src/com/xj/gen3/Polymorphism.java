package com.xj.gen3;

import java.util.ArrayList;
import java.util.List;

/**
 * ����û�ж�̬
 * 
 * @author Administrator
 * 
 */
public class Polymorphism {
	public static void main(String[] args) {
		// ��̬
		Fruit f = new Apple();
		/*
		 * ����û�ж�̬
		List<Fruit>list=new ArrayList<Apple>();
		 */
		List<? extends Fruit> list = new ArrayList<Apple>();
		
		/*
		 * ����û������
		Fruit<String>[] arr=new Fruit<String>[10];
		*/
		
		//JDK 1.7 �Է��͵ļ򻯲���  ����������ָ������
		List<Fruit>list1=new ArrayList<>();		
	}
}
