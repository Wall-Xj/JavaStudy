package com.xiejun.reflect;

public class demo01 {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		String  str ="abc";
		//Class对象
		//对象.getClass()
		Class<?> clz =str.getClass();
		//类.class
		clz =String.class;
		//完整路径
		clz=Class.forName("java.lang.String");
	}

}
