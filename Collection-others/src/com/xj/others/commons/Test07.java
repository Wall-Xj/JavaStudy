package com.xj.others.commons;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.apache.commons.collections4.bidimap.DualTreeBidiMap;

/**
 * 双向Map 要求键与值都不能重复
 * BidiMap
 * 1、DualTreeBidiMap：有序
 * 2、DualHashBidiMap：无序
 * @author Administrator
 *
 */
public class Test07 {
	public static void main(String[] args) {
		 //hashMap();
		 TreeMap();
	}
	/**
	 * 有序的双向Map
	 */
	public static void TreeMap(){
		System.out.println("======有序的双向Map=======");
		BidiMap<String,String>map=new DualTreeBidiMap<String,String>();
		map.put("a", "hangzhou");
		map.put("b","shanghai");
		map.put("c", "beijing");
		//反转
		System.out.println(map.inverseBidiMap().get("hangzhou"));
		//遍历查看
		MapIterator<String,String>it=map.inverseBidiMap().mapIterator();
		while(it.hasNext()){
			String key=it.next();
			String value=it.getValue();
			System.out.println(key+"==>"+value);
		}
	}
	/**
	 * 无序的双向Map
	 */
	public static void hashMap(){
		System.out.println("======无序的双向Map=======");
		BidiMap<String,String>map=new DualHashBidiMap<String,String>();
		map.put("a", "hangzhou");
		map.put("b","shanghai");
		map.put("c", "beijing");
		//反转
		System.out.println(map.inverseBidiMap().get("hangzhou"));
		//遍历查看
		MapIterator<String,String>it=map.inverseBidiMap().mapIterator();
		while(it.hasNext()){
			String key=it.next();
			String value=it.getValue();
			System.out.println(key+"==>"+value);
		}
	}
}
