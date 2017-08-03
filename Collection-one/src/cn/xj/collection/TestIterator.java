package cn.xj.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class TestIterator {
	public static void main(String[] args) {
		Set set=new HashSet();
		set.add("111");
		set.add("444");
		set.add("333");
		
		Iterator iter=set.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
		
//		for(Iterator iter=set.iterator();iter.hasNext();){
//			System.out.println(iter.next());
//		}
		
		List list=new ArrayList();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		for(Iterator iter1=list.iterator();iter1.hasNext();){
			System.out.println(iter1.next());
		}
		
	}
}
