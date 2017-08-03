package com.xj.others.three;

import java.util.WeakHashMap;

/**
 * WeakHashMap ��Ϊ�����ͣ�gc������������
 * @author Administrator
 *
 */
public class WeakHashMapTest {
	public static void main(String[] args) {
		WeakHashMap<String,String>map=new WeakHashMap<String,String>();
		//�����ض��󣬲������
		map.put("A", "aaa");
		map.put("B", "bbb");
		//gc���У��ѱ�����
		map.put(new String("C"), "ccc");
		map.put(new String("D"), "ddd");
		System.out.println("gc����ǰ��"+map.size());
		System.gc();
		System.runFinalization();
		System.out.println("gc���к�"+map.size());
	}
}


