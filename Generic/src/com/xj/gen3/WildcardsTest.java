package com.xj.gen3;

import java.util.ArrayList;
import java.util.List;

/**
 * ? -->ͨ��������Ͳ�ȷ����������������|�β���
 * �������ڣ�
 * 1����������
 * 2������������| ���ͷ���| ���ͽӿ���
 * @author Administrator
 *
 */
public class WildcardsTest {
	public static void main(String[] args) {
		//����
		List<?>list=new ArrayList<Integer>();
		test(list);
		list=new ArrayList<String>();
		test(list);
		list=new ArrayList<Object>();
		test(list);
		
//		������� �������ڴ�������
//		list=new ArrayList<?>();
	}
	
	public static void test(List<?> list){
		
	}
	
	/*
	 * ������󣬲������ڴ������ͷ���
	public static <?> void test2<List<?> list>{
		
	}*/
	
	class Test<T>{
		
	}
	
	/*
	 * ������󣬲������ڴ���������
	class Test<?>{
		
	}*/
}


