package com.xj.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest01 {
	public static void main(String[] args) {
		String[] arr="this is a cat and that is a mice and where is a dag".split(" ");
		Map<String,Integer>map=new HashMap<String,Integer>();
		for(String key :arr){
			if(!map.containsKey(key)){
				map.put(key, 1);
			}else{
				map.put(key, map.get(key)+1);
			}
		}
		
		Iterator<Map.Entry<String,Integer>>iter=map.entrySet().iterator();
		while(iter.hasNext()){
			Map.Entry<String,Integer>entry=iter.next();
			System.out.println(entry.getKey()+"-->"+entry.getValue());
		}
		System.out.println("-------------------");
		for(Map.Entry<String, Integer> entry:map.entrySet()){
			System.out.println(entry.getKey()+"-->"+entry.getValue());
		}
		System.out.println("-------------------");
		Set<String> keySet=map.keySet();
		Iterator<String>it=keySet.iterator();
		while(it.hasNext()){
			String key=it.next();
			Integer value=map.get(key);
			System.out.println(key+"-->"+value);
		}
	}
}
