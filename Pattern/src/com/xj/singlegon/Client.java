package com.xj.singlegon;

/**
 * @author WanYin
 *
 */
public class Client {
	public static void main(String[] args) {
		Demo01 d1=Demo01.getInstance();
		Demo01 d2=Demo01.getInstance();
		
		System.out.println(d1);
		System.out.println(d2);
		
		System.out.println(Demo04.INSTANCE);
		System.out.println(Demo04.INSTANCE);
	}
}
