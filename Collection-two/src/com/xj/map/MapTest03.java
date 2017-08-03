package com.xj.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest03 {
	public static void main(String[] args) {
		Map<String,ClassRoom>map=new HashMap<String,ClassRoom>();
		map=count(exam());
		view(map);
	}
	
	private static void view(Map<String,ClassRoom>map){
		for(Map.Entry<String, ClassRoom>entry:map.entrySet()){
			System.out.println(entry.getKey()+" total:"+entry.getValue().getTotal());
			System.out.println(entry.getKey()+" avg:"+entry.getValue().getTotal()/entry.getValue().getStuList().size());
		}
	}
	
	private static Map<String,ClassRoom>count(List<Student> list){
		Map<String,ClassRoom>map=new HashMap<String,ClassRoom>();
		for(Student stu:list){
			String no=stu.getNo();
			double score=stu.getScore();
			ClassRoom cr=map.get(stu.getNo());
			if(null==cr){
				cr=new ClassRoom(no);
				map.put(no, cr);
			}
			cr.getStuList().add(stu);
			cr.setTotal(score+cr.getTotal());
		}
		
		return map;
	}
	
	
	private static List<Student> exam(){
		List<Student>list=new ArrayList<Student>();
		list.add(new Student("tom","A",87));
		list.add(new Student("jack","A",90));
		list.add(new Student("marry","A",80));
		list.add(new Student("jay","B",85));
		list.add(new Student("b","B",95));
		return list;
	}
	
}
