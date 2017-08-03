package com.xj.others.commons;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.apache.commons.collections4.bidimap.DualTreeBidiMap;

/**
 * ˫��Map Ҫ�����ֵ�������ظ�
 * BidiMap
 * 1��DualTreeBidiMap������
 * 2��DualHashBidiMap������
 * @author Administrator
 *
 */
public class Test07 {
	public static void main(String[] args) {
		 //hashMap();
		 TreeMap();
	}
	/**
	 * �����˫��Map
	 */
	public static void TreeMap(){
		System.out.println("======�����˫��Map=======");
		BidiMap<String,String>map=new DualTreeBidiMap<String,String>();
		map.put("a", "hangzhou");
		map.put("b","shanghai");
		map.put("c", "beijing");
		//��ת
		System.out.println(map.inverseBidiMap().get("hangzhou"));
		//�����鿴
		MapIterator<String,String>it=map.inverseBidiMap().mapIterator();
		while(it.hasNext()){
			String key=it.next();
			String value=it.getValue();
			System.out.println(key+"==>"+value);
		}
	}
	/**
	 * �����˫��Map
	 */
	public static void hashMap(){
		System.out.println("======�����˫��Map=======");
		BidiMap<String,String>map=new DualHashBidiMap<String,String>();
		map.put("a", "hangzhou");
		map.put("b","shanghai");
		map.put("c", "beijing");
		//��ת
		System.out.println(map.inverseBidiMap().get("hangzhou"));
		//�����鿴
		MapIterator<String,String>it=map.inverseBidiMap().mapIterator();
		while(it.hasNext()){
			String key=it.next();
			String value=it.getValue();
			System.out.println(key+"==>"+value);
		}
	}
}
