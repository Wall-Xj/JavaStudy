package com.xj.gen3;

import java.util.ArrayList;
import java.util.List;


/**
 * extends:��ʾ���͵�����  <= ������
 * 1��һ���������Ʋ���
 * 2������ʹ��������������棬һ�㶼�Ƕ�ȡ����
 * 3������
 *  List<Fruit>-->List<? extends Fruit>
 *  List<Apple>-->List<? extends Fruit>
 *  List<? extends Apple>-->List<? extends Fruit>
 *  ���ܴ��
 *  List<?>
 *  List<? extends Object>
 * 
 * @author Administrator
 * 
 */
public class ExtendsTest {
	public static void main(String[] args) {
		//extends Ϊ����
		Test<Fruit>t1=new Test<Fruit>();
		Test<Apple>t2=new Test<Apple>();
		Test<Pear>t3=new Test<Pear>();
		
		//���÷���
		List<? extends Fruit> list1=new ArrayList<Fruit>();
		test(list1);
		List<Fruit> list2=new ArrayList<Fruit>();
		test(list2);
		List<Apple> list3=new ArrayList<Apple>();
		test(list3);
		List<? extends Apple> list4=new ArrayList<FujiApple>();
		test(list4);

		/*
		 * ?-->����? ��ͬ�� ? extends Object
		List<?>list5=new ArrayList<Object>();
		List<? extends Object>list6=new ArrayList<Object>();
		test(test6);
		*/
	}
	
	//? extends Fruit
	public static void test(List<? extends Fruit>list){
		/*
		 * ����,�������������Ϣ
		list.add(new Apple());
		list.add(new FujiApple());
		list.add(new Pear());
		list.add(new Fruit());
		*/
		list.add(null);
	}
	
	//������
	static class Test<T extends Fruit>{
		
	}
}
