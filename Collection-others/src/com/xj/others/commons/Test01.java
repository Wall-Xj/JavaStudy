package com.xj.others.commons;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.PredicateUtils;
import org.apache.commons.collections4.functors.EqualPredicate;
import org.apache.commons.collections4.functors.NotNullPredicate;
import org.apache.commons.collections4.functors.UniquePredicate;
import org.apache.commons.collections4.list.PredicatedList;


/**
 * ����ʽ��� Predicate ����s
 * ��װ�������б�ʽ if--else���
 * 1��new EqualPredicate<����>(ֵ);
 * 	EqualPredicate.equalPredicate(ֵ);
 * 2��NotNullPredicate.INSTANCE
 * 	NotNullPredicate.notNullPredicate();
 * 3��UniquePredicate.uniquePredicate()
 * 4���Զ���
 * 	PredicateUtils.allPrediacte andPredicate anyPredicate
 * 
 * 	PredicatedXxx.predicatedXxx(����, �ж�);
 * @author Administrator
 *
 */
public class Test01 {
	public static void main(String[] args) {
		System.out.println("===========�Զ����ж�===========");
		//�Զ�����б�ʽ
		Predicate<String>selfPre=new Predicate<String>(){

			@Override
			public boolean evaluate(String object) {
				return object.length()>=5&&object.length()<=20;
			}
			
		};
		Predicate notNull=NotNullPredicate.notNullPredicate();
		Predicate all=PredicateUtils.allPredicate(notNull,selfPre);
		List<String>list=PredicatedList.predicatedList(new ArrayList<String>(), all);
		list.add("xiejun");
		list.add(null);
		list.add("jun");
	}
	
	/**
	 * �ж�Ψһ��
	 */
	public static void unique(){
		System.out.println("==========Ψһ���ж�=========");	
		Predicate<Long>uniquePre=UniquePredicate.uniquePredicate();
		List<Long>list=PredicatedList.predicatedList(new ArrayList<Long>(), uniquePre);
		list.add(100L);
		list.add(200L);
		list.add(100L);//�����ظ����׳��쳣
	}
	
	
	/**
	 * �жϷǿ�
	 */
	public static void notNull(){
		System.out.println("============�ǿ��ж�============");
		//Predicate notNull=NotNullPredicate.INSTANCE;
		Predicate notNull=NotNullPredicate.notNullPredicate();
		//String str="xie";
		String str=null;
		System.out.println(notNull.evaluate(str));
		
		//�������ֵ���ж�
		List<Long> list=PredicatedList.predicatedList(new ArrayList<Long>(), notNull);
		list.add(1000L);
		list.add(null);//��֤ʧ�ܣ������쳣
	}
	
	/**
	 * �Ƚ�����ж�
	 */
	public static void equal(){
		System.out.println("============����ж�============");
//		Predicate<String>pre=new EqualPredicate<String>("xiejun");
		Predicate<String>pre=EqualPredicate.equalPredicate("xiejun");
		boolean flag=pre.evaluate("xie");
		System.out.println(flag);
	}
}
