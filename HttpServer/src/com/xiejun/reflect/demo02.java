package com.xiejun.reflect;

import com.xiejun.server.demo03.Servlet;

public class demo02 {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?>clz=Class.forName("com.xiejun.demo03.LoginServlet");
		Servlet ser=(Servlet)clz.newInstance();

	}

}
