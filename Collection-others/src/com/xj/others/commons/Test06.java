package com.xj.others.commons;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections4.IterableMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.iterators.ArrayListIterator;
import org.apache.commons.collections4.iterators.FilterIterator;
import org.apache.commons.collections4.iterators.LoopingIterator;
import org.apache.commons.collections4.iterators.UniqueFilterIterator;
import org.apache.commons.collections4.map.HashedMap;

/**
 * 迭代器的扩展
 * 1、MapIterator 以后不在使用map.ketSet.iterator访问
 * IterableMap HashedMap
 * 2、UniqueFilterIterator 去重迭代器
 * 3、FilterIterator 自定义过滤器+断言Predicate
 * 4、LoopingIterator	循环迭代器
 * 5、ArrayListIterator 数组迭代器
 * 
 * @author Administrator
 *
 */
public class Test06 {
	public static void main(String[] args) {
		//mapIt();
		//uniqueIt();
		//filterIt();
		//loopIt();
		arrayIt();
	}
	/**
	 * 数组迭代器
	 */
	public static void arrayIt(){
		System.out.println("========数组迭代器=======");
		int[] arr={1,2,3,4,5};
		//数组迭代器
		//Iterator<Integer>it=new ArrayListIterator<Integer>(arr);
		//指定起始索引和结束索引
		Iterator<Integer>it=new ArrayListIterator<Integer>(arr,1,3);
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	/**
	 * 循环迭代器
	 */
	public static void loopIt(){
		System.out.println("=======循环迭代器======");
		List<String>list=new ArrayList<String>();
		list.add("refer");
		list.add("mom");
		list.add("mac");
		list.add("dad");
		Iterator<String>it=new LoopingIterator(list);
		for(int i=0;i<3;i++){
			System.out.println(it.next());
		}
	}
	/**
	 * 自定义迭代器
	 */
	public static void filterIt(){
		List<String>list=new ArrayList<String>();
		list.add("refer");
		list.add("dad");
		list.add("mac");
		//自定义条件判断
		Predicate<String>pre=new Predicate<String>(){

			@Override
			public boolean evaluate(String object) {
				//回文判断
				return new StringBuilder(object).reverse().toString().equals(object);
			}
			
		};
		//去除重复的过滤器
		Iterator<String>it=new FilterIterator(list.iterator(),pre);
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	/**
	 * 去重迭代器
	 */
	public static void uniqueIt(){
		List<String>list=new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("a");
		//去除重复的过滤器
		Iterator<String>it=new UniqueFilterIterator(list.iterator());
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	/**
	 * map迭代器
	 */
	public static void mapIt(){
		System.out.println("======map迭代器=======");
		IterableMap<String,String>map=new HashedMap<String,String>();
		map.put("a", "beijing");
		map.put("b", "shanghai");
		map.put("c", "hangzhou");
		//使用MapIterator
		MapIterator<String,String>it=map.mapIterator();
		while(it.hasNext()){
			String key=it.next();
			String value=it.getValue();
			System.out.println(key+"==>"+value);
		}
	}
}
