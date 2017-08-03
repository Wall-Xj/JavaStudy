package cn.xj.iterator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test01 {
	public static void main(String[] args) {
		System.out.println("-------List------");
		List<String> list = new ArrayList<String>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");

		System.out.println("-------111------");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		System.out.println("-------222------");
		for (String str : list) {
			System.out.println(str);
		}

		System.out.println("-------333------");
		for (Iterator<String> iter = list.iterator(); iter.hasNext();) {
			System.out.println(iter.next());
		}

		System.out.println("-------Map------");
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(1, 111);
		map.put(2, 222);
		map.put(3, 333);

		System.out.println("-------111------");
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.println("Key: " + entry.getKey() + " Value: "
					+ entry.getValue());
		}

		System.out.println("-------222------");
		for (Integer key : map.keySet()) {
			System.out.println("Key:" + key);
		}

		System.out.println("-------333------");
		for (Integer value : map.values()) {
			System.out.println("Value:" + value);
		}

		System.out.println("------444-------");
		Iterator<Map.Entry<Integer, Integer>> iter1 = map.entrySet().iterator();
		while (iter1.hasNext()) {
			Map.Entry<Integer, Integer> entry = iter1.next();
			System.out.println("Key: " + entry.getKey() + " Value: "
					+ entry.getValue());
		}

		System.out.println("------555-------");
		Map map1 = new HashMap();
		map1.put(1, 111);
		map1.put(2, 222);
		map1.put(3, 333);
		Iterator iter2 = map1.entrySet().iterator();
		while (iter2.hasNext()) {
			Map.Entry entry = (Map.Entry) iter2.next();
			System.out.println("Key: " + entry.getKey() + " Value: "
					+ entry.getValue());
		}

		System.out.println("------666-------");
		for (Integer key : map.keySet()) {
			Integer value = map.get(key);
			System.out.println("Key: " + key + " Value: " + value);
		}

		System.out.println("------Set-------");
		Set<String> set = new HashSet<String>();
		set.add("qqq");
		set.add("www");
		set.add("eee");
		
		System.out.println("------111-------");
		Iterator<String> iter3 = set.iterator();
		while (iter3.hasNext()) {
			System.out.println(iter3.next());
		}
		
		System.out.println("------222-------");
		for(Iterator<String>iter=set.iterator();iter.hasNext();){
			System.out.println(iter.next());
		}
	}
}
