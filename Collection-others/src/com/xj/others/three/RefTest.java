package com.xj.others.three;

import java.lang.ref.WeakReference;

/**
 * 引用的分类：强、软、弱、虚
 * 强与弱引用
 * @author Administrator
 *
 */
public class RefTest {
	public static void main(String[] args) {
		//字符串常量池 共享（不能回收）
		String str=new String("No fucking excuses. Just go！");
		WeakReference<String>wr=new WeakReference<String>(str);
		System.out.println("GC运行前："+wr.get());
		//断开引用
		str=null;
		System.gc();
		System.runFinalization();
		System.out.println("GC运行后："+wr.get());
	}
	
	public static void test(){
		//字符串常量池 共享（不能回收）
		String str="No fucking excuses. Just go！";
		WeakReference<String>wr=new WeakReference<String>(str);
		System.out.println("GC运行前："+wr.get());
		//断开引用
		str=null;
		System.gc();
		System.runFinalization();
		System.out.println("GC运行后："+wr.get());
	}
}
