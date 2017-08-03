package cn.xj.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestSet {
	public static void main(String[] args) {
		Set set=new HashSet();
		set.add("aaa");
		set.add("bbb");
		set.add(new String("aaa"));
		System.out.println(set.size());
		boolean bool=set.contains(new String("bbb"));
		System.out.println(bool);
		Iterator ite = set.iterator();
		while (ite.hasNext()) {  
            String p = (String)ite.next();  
            System.out.println(p);  
        }
	}
}
