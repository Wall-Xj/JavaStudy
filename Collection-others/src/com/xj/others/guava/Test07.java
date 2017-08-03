package com.xj.others.guava;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * HashMap 键唯一，只可以重复
 * BiMap：双向Map（Bidirectional Map）键与值都不能重复（unique -valued map）
 * @author Administrator
 *
 */
public class Test07 {
	public static void main(String[] args) {
		BiMap<String,String>bimap=HashBiMap.create();
		bimap.put("mary", "mary@163.com");
		bimap.put("grean", "grean@qq.com");
		//通过邮箱找用户
		String user=bimap.inverse().get("grean@qq.com");
		System.out.println(user);
		System.out.println(bimap.inverse().inverse()==bimap);
	}
}
