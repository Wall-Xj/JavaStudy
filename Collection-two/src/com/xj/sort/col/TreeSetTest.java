package com.xj.sort.col;

import java.util.TreeSet;
/**
 * TreeSet在添加数据时排序
 * 
 * @author Administrator
 *
 */
public class TreeSetTest {
	public static void main(String[] args) {
		TreeSet<Person> set = new TreeSet<Person>(
				new java.util.Comparator<Person>() {
					@Override
					public int compare(Person o1, Person o2) {
						return o1.getHandsome() - o2.getHandsome();
					}

				});
		set.add(new Person("tom",100));
		set.add(new Person("bob",120));
		set.add(new Person("jack",90));
		set.add(new Person("mary",150));
		System.out.println(set);
		
		
		TreeSet<Worker>set1=new TreeSet<Worker>();
		set1.add(new Worker("tom",10000));
		set1.add(new Worker("bob",8000));
		set1.add(new Worker("jack",9000));
		set1.add(new Worker("mary",7000));
		System.out.println(set1);
	}
}
