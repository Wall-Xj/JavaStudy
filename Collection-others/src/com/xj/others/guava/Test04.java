package com.xj.others.guava;

import java.util.Set;

import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;

/**
 * ���ϲ������������������
 * Sets.intersection()
 * Sets.difference()
 * Sets.union()
 * @author Administrator
 * 
 */
public class Test04 {
	public static void main(String[] args) {
		Set<Integer> set1 = Sets.newHashSet(1, 2, 3, 4, 5, 6);
		Set<Integer> set2 = Sets.newHashSet(4, 5, 6, 7, 8, 9);

		// ����
		System.out.println("����Ϊ��");
		SetView<Integer> intersection = Sets.intersection(set1, set2);
		for(Integer temp:intersection){
			System.out.println(temp);
		}
		//�
		System.out.println("�Ϊ��");
		SetView<Integer>difference=Sets.difference(set1, set2);
		for(Integer temp:difference){
			System.out.println(temp);
		}
		//����
		System.out.println("����Ϊ��");
		SetView<Integer>union=Sets.union(set1, set2);
		for(Integer temp:union){
			System.out.println(temp);
		}
	}
}
