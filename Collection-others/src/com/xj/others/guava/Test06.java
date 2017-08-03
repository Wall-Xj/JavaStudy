package com.xj.others.guava;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

/**
 * �����鿴 ��ʦ ���ڵ�ÿ�ſγ� Multimap :key-value key�����ظ�
 * 
 * @author Administrator
 * 
 */
public class Test06 {
	public static void main(String[] args) {
		Map<String, String> cours = new HashMap<String, String>();
		cours.put("one", "tom");
		cours.put("two", "jack");
		cours.put("three", "bob");
		cours.put("four", "bob");
		// Multimap
		Multimap<String, String> teachers = ArrayListMultimap.create();
		// ������
		Iterator<Map.Entry<String, String>> it = cours.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> entry = it.next();
			String key = entry.getKey();
			String value = entry.getValue();
			teachers.put(value, key);
		}
		// �鿴Multimap
		for (String key : teachers.keySet()) {
			Collection<String> col = teachers.get(key);
			System.out.println(key + "-->" + col);
		}
	}
}
