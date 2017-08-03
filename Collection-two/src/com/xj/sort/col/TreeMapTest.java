package com.xj.sort.col;

import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class TreeMapTest {
	public static void main(String[] args) {
		TreeMap<Person,String> set = new TreeMap<Person,String>(
				new java.util.Comparator<Person>() {
					@Override
					public int compare(Person o1, Person o2) {
						return o2.getHandsome() - o1.getHandsome();
					}

				});
		set.put(new Person("tom",100),"xj");
		set.put(new Person("bob",120),"xj");
		set.put(new Person("jack",90),"xj");
		set.put(new Person("mary",150),"xj");
		Set<Person>persons=set.keySet();
		System.out.println(persons);
		
		
		TreeMap<Worker,String>set1=new TreeMap<Worker,String>();
		set1.put(new Worker("tom",10000),"xj");
		set1.put(new Worker("bob",8000),"xj");
		set1.put(new Worker("jack",9000),"xj");
		set1.put(new Worker("mary",7000),"xj");
		Set<Worker>workers=set1.keySet();
		System.out.println(workers);
		
	}
}
