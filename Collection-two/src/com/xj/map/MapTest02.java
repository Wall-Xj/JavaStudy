package com.xj.map;

import java.util.HashMap;
import java.util.Map;

public class MapTest02 {
	public static void main(String[] args) {
		String[] arr="this is a cat and that is a mice and where is a dag".split(" ");
		Map<String,Letter>map=new HashMap<String,Letter>();
		for(String key :arr){
			if(!map.containsKey(key)){
				map.put(key,new Letter(key));
			}
			Letter value= map.get(key);
			value.setCount(value.getCount()+1);
		}
		
		for(String key:map.keySet()){
			Letter value=map.get(key);
			System.out.println(key+"-->"+value.getCount());
		}
	}
}
