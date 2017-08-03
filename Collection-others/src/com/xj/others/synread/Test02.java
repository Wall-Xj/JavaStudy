package com.xj.others.synread;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 制度设置
 * 1、emptyXxx() 空的不可变集合
 * 	emptyList()
 * 	emptyMap() 
 * 	emptySet()
 * 2、singletonXxx() 元素不可变的容器
 * 	singleton(T o) 
 * 	singletonList(T o) 
 * 	singletonMap(K key, V value) 
 * 3、unmodifiableXxx() 返回指定 collection 的不可修改视图
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
		
		//只读控制
		Map<String,String>map2=Collections.unmodifiableMap(map);
//		map2.put("c", "ccc");	//不能操作
		System.out.println(map2.size());
		
		//一个元素的容器
		List<String>list=Collections.singletonList(new String());
		list.add("test");
//		list.add("demo");	//只能包含一个元素的容器
		
	}
	
	public static Set<String>oper(Set<String>set){
		if(null==set){
			return Collections.EMPTY_SET;	//外部获取避免NullPointerException
		}
		return set;
	}
}
