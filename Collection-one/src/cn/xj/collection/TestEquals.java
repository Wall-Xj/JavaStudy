package cn.xj.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TestEquals {
	public static void main(String[] args) {
		List list = new LinkedList();
		list.add(new String("aaa"));
		list.add(new String("aaa"));
		System.out.println(list);
		
		Integer s1=new Integer(123);
		Integer s2=new Integer(123);
		Map map=new HashMap();
		map.put(s2, "hhh");
		map.put(s1, "ddd");
		System.out.println(map.get(123));
		
		
	}
}
