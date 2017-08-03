package com.xj.others.en;

import java.util.Enumeration;
import java.util.Vector;

public class Test01 {
	public static void main(String[] args) {
		Vector<String>vector=new Vector<String>();
		vector.add("javase");
		vector.add("C#");
		vector.add("oracle");
		Enumeration<String>en=vector.elements();
		while(en.hasMoreElements()){
			System.out.println(en.nextElement());
		}
	}
}
