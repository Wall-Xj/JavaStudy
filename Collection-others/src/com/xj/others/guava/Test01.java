package com.xj.others.guava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.ImmutableList;

/**
 * ֻ������
 * @author Administrator
 *
 */
public class Test01 {
	public static void main(String[] args) {
		List<String>list=new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		//��ԭ�е�List���а�װ�������ԭ��List��һ����ͼ�����գ�������ȫ
		List<String>readlist=Collections.unmodifiableList(list);
		//java.lang.UnsupportedOperationException
		//readlist.add("d");
		list.add("d");//�ı�ԭ�е�List ��ͼҲһ��ı�
		
		//�ԱȲ鿴 ��ʼ��List guava��ֻ������ ��ȫ�ɿ���������Լ�
		List<String>immutableList=ImmutableList.of("a","b","c");
		immutableList.add("d");
	}
}
