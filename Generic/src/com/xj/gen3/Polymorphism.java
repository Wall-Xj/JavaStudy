package com.xj.gen3;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型没有多态
 * 
 * @author Administrator
 * 
 */
public class Polymorphism {
	public static void main(String[] args) {
		// 多态
		Fruit f = new Apple();
		/*
		 * 泛型没有多态
		List<Fruit>list=new ArrayList<Apple>();
		 */
		List<? extends Fruit> list = new ArrayList<Apple>();
		
		/*
		 * 泛型没有数组
		Fruit<String>[] arr=new Fruit<String>[10];
		*/
		
		//JDK 1.7 对泛型的简化操作  创建对象不用指定类型
		List<Fruit>list1=new ArrayList<>();		
	}
}
