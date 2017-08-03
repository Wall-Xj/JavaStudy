package com.xj.others.guava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.ImmutableList;

/**
 * 只读设置
 * @author Administrator
 *
 */
public class Test01 {
	public static void main(String[] args) {
		List<String>list=new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		//对原有的List进行包装，相等于原有List的一个视图，快照，不够安全
		List<String>readlist=Collections.unmodifiableList(list);
		//java.lang.UnsupportedOperationException
		//readlist.add("d");
		list.add("d");//改变原有的List 视图也一起改变
		
		//对比查看 初始化List guava对只读设置 安全可靠，并且相对简单
		List<String>immutableList=ImmutableList.of("a","b","c");
		immutableList.add("d");
	}
}
