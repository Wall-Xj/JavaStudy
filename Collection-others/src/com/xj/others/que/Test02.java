package com.xj.others.que;

public class Test02 {
	public static void main(String[] args) {
		MyStack<String> stack = new MyStack<String>(3);
		stack.push("aaa");
		stack.push("bbb");
		stack.push("ccc");
		stack.push("ddd");
		
		System.out.println("ด๓ะกฃบ"+stack.size());
		
		String item=null;
		while((item=stack.pop())!=null){
			System.out.println(item);
		}
	}
}
