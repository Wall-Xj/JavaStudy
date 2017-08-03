package com.xj.gen3;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 泛型嵌套-->由外到内拆分
 * 
 * 
 * @author Administrator
 * 
 */
public class StudentApp {
	public static void main(String[] args) {
		Student<String> stu = new Student<String>();
		stu.setScore("优秀");
		Xj<Student<String>> xj = new Xj<Student<String>>();
		xj.setStu(stu);
		
		stu=xj.getStu();
		String score=stu.getScore();
		System.out.println(score);
		
		
		Map<Integer,String>map=new HashMap<Integer,String>();
		map.put(1,"aaa");
		map.put(2,"bbb");
		Set<Entry<Integer,String>>entrySet=map.entrySet();
		for(Entry<Integer,String> entry:entrySet){
			System.out.println("Key: "+entry.getKey()+" Value: "+entry.getValue());
		}
		for(Map.Entry<Integer,String> entry:map.entrySet()){
			System.out.println("Key: "+entry.getKey()+" Value: "+entry.getValue());
		}
		
	}

}
