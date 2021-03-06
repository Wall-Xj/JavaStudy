package com.xj.others.guava;

import java.util.Set;

import com.google.common.base.Preconditions;
import com.google.common.collect.Constraint;
import com.google.common.collect.Constraints;
import com.google.common.collect.Sets;

/**
 * 加入约束条件：非空、长度验证
 * Constraint
 * Preconditions
 * Constraints
 * @author Administrator
 *
 */
public class Test03 {
	public static void main(String[] args) {
		Set<String>sets=Sets.newHashSet();
		//创建约束
		Constraint<String>constraint=new Constraint<String>(){

			@Override
			public String checkElement(String element) {
				// 非空验证
				Preconditions.checkNotNull(element);
				//长度验证
				Preconditions.checkArgument(element.length()>=5&&element.length()<=20);
				return element;
			}
			
		};
		Set<String>cs=Constraints.constrainedSet(sets, constraint);
		//cs.add(null);	//java.lang.NullPointerException
		//cs.add("yes");	//java.lang.IllegalArgumentException
		cs.add("shanghai");
		for(String str:cs){
			System.out.println(str);
		}
	}
}
