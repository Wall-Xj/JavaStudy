package com.xj.others.three;

import java.util.WeakHashMap;

/**
 * WeakHashMap 键为弱类型，gc运行立即回收
 * @author Administrator
 *
 */
public class WeakHashMapTest {
	public static void main(String[] args) {
		WeakHashMap<String,String>map=new WeakHashMap<String,String>();
		//常量池对象，不会回收
		map.put("A", "aaa");
		map.put("B", "bbb");
		//gc运行，已被回收
		map.put(new String("C"), "ccc");
		map.put(new String("D"), "ddd");
		System.out.println("gc运行前："+map.size());
		System.gc();
		System.runFinalization();
		System.out.println("gc运行后："+map.size());
	}
}


