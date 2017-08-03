package com.xj.sort.innerType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test02 {
	public static void main(String[] args) {
		String[] arr={"das","s","adsd","sd"};
		Comparator com=new StringComparator();
		Utils.sort(arr, com);
		System.out.println(Arrays.toString(arr));
		
		
		List<String>list=new ArrayList<String>();
		list.add("a");
		list.add("ads");
		list.add("as");
		Utils.sort(list,com);
		System.out.println(list);
		
		List<String>list1=new ArrayList<String>();
		list1.add("a");
		list1.add("ads");
		list1.add("as");
		Collections.sort(list1, new StringComparator());
		System.out.println(list1);
		
		
		list1=new ArrayList<String>();
		list1.add("a");
		list1.add("ads");
		list1.add("as");
		Collections.sort(list1);
		System.out.println(list1);
	}
}
