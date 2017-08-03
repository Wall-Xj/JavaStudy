package com.xj.gen3;

import java.util.ArrayList;
import java.util.List;

import com.xj.gen3.ExtendsTest.Test;

/**
 * super:表示泛型的下限  >= 即父类或自身
 * 1、一般用于下限操作
 * 2、能使用在添加数据上面，不能添加父对象
 * 3、规则
 *  List<Fruit>-->List<? super Apple>
 *  List<Apple>-->List<? super Apple>
 *  List<? super Fruit>-->List<? super Apple>
 *  不能存放
 *  List<?>
 *  List<? super Object> 
 * 
 * @author Administrator
 *
 */
public class SuperTest {
	public static void main(String[] args) {
		//extends 为上限
		Test<Fruit>t1=new Test<Fruit>();
		Test<Apple>t2=new Test<Apple>();
		Test<Pear>t3=new Test<Pear>();
		
		//调用方法
		List<Apple> list1=new ArrayList<Apple>();
		test(list1);
		List<Fruit> list2=new ArrayList<Fruit>();
		test(list2);
		List<Object> list3=new ArrayList<Object>();
		test(list3);
		
		//规则
		List<? super Apple> list4=new ArrayList<Apple>();
		test(list4);
		List<? super Fruit> list5=new ArrayList<Fruit>();
		test(list5);
		List<? super FujiApple> list6=new ArrayList<Object>();
		//test(list6);
		List<?>list7=new ArrayList<Object>();
		//test(list7);
		
	}
	
	//? super Apple
	public static void test(List<? super Apple>list){
		list.add(new Apple());
		list.add(new FujiApple());
		list.add(null);
		/*
		 * 不能添加父类对象
		list.add(new Fruit());
		*/
	}
	

}
