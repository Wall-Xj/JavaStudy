package com.xiejun.reflect;

public class demo01 {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		String  str ="abc";
		//Class����
		//����.getClass()
		Class<?> clz =str.getClass();
		//��.class
		clz =String.class;
		//����·��
		clz=Class.forName("java.lang.String");
	}

}
