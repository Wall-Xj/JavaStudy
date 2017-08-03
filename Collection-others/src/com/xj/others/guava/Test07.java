package com.xj.others.guava;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * HashMap ��Ψһ��ֻ�����ظ�
 * BiMap��˫��Map��Bidirectional Map������ֵ�������ظ���unique -valued map��
 * @author Administrator
 *
 */
public class Test07 {
	public static void main(String[] args) {
		BiMap<String,String>bimap=HashBiMap.create();
		bimap.put("mary", "mary@163.com");
		bimap.put("grean", "grean@qq.com");
		//ͨ���������û�
		String user=bimap.inverse().get("grean@qq.com");
		System.out.println(user);
		System.out.println(bimap.inverse().inverse()==bimap);
	}
}
