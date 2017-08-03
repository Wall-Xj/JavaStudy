package com.xj.others.synread;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * �ƶ�����
 * 1��emptyXxx() �յĲ��ɱ伯��
 * 	emptyList()
 * 	emptyMap() 
 * 	emptySet()
 * 2��singletonXxx() Ԫ�ز��ɱ������
 * 	singleton(T o) 
 * 	singletonList(T o) 
 * 	singletonMap(K key, V value) 
 * 3��unmodifiableXxx() ����ָ�� collection �Ĳ����޸���ͼ
 * 	unmodifiableList(List<? extends T> list) 
 * 	unmodifiableMap(Map<? extends K,? extends V> m) 
 * 	unmodifiableSet(Set<? extends T> s) 
 * 
 * @author Administrator
 *
 */
public class Test02 {
	public static void main(String[] args) {
		HashMap<String,String>map=new HashMap<String,String>();
		map.put("a", "aaa");
		map.put("b", "bbb");
		
		//ֻ������
		Map<String,String>map2=Collections.unmodifiableMap(map);
//		map2.put("c", "ccc");	//���ܲ���
		System.out.println(map2.size());
		
		//һ��Ԫ�ص�����
		List<String>list=Collections.singletonList(new String());
		list.add("test");
//		list.add("demo");	//ֻ�ܰ���һ��Ԫ�ص�����
		
	}
	
	public static Set<String>oper(Set<String>set){
		if(null==set){
			return Collections.EMPTY_SET;	//�ⲿ��ȡ����NullPointerException
		}
		return set;
	}
}
