package com.xj.others.synread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ʹ��Collections����ͬ������
 * synchronizedList(List<T> list) 
 * synchronizedMap(Map<K,V> m)
 * synchronizedSet(Set<T> s) 

 * @author Administrator
 *
 */
public class Test01 {
	public static void main(String[] args) {
		List<String>list=new ArrayList<String>();
		list.add("a");
		list.add("b");
		//�̰߳�ȫ��list
		List<String>synlist=Collections.synchronizedList(list);
		
	}
}
