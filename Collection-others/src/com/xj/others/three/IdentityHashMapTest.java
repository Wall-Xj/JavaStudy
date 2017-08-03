package com.xj.others.three;

import java.util.IdentityHashMap;
import java.util.Map;

/**
 * IdentityHashMap 键比较地址去重
 * 
 * @author Administrator
 * 
 */
public class IdentityHashMapTest {
	public static void main(String[] args) {
		IdentityHashMap<String, String> map = new IdentityHashMap<String, String>();
		map.put("a", "1");
		map.put("a", "2");
		map.put(new String("a"), "3");
		map.put(new String("a"), "4");
		for (Map.Entry<String,String> entry : map.entrySet()) {
			System.out.println("Key: " + entry.getKey() + " Value: "
					+ entry.getValue());
		}
	}
}
