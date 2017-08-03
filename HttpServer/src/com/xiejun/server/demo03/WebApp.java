package com.xiejun.server.demo03;

import java.util.Map;

public class WebApp {
	private static ServletContext contxt;
	static{
		contxt =new ServletContext();
		
		Map<String,String> mapping =contxt.getMapping();
		mapping.put("/login", "login");
		mapping.put("/log", "login");
		mapping.put("/reg", "register");
		
		Map<String,String> servlet =contxt.getServlet();
		servlet.put("login", "com.xiejun.server.demo03.LoginServlet");
		servlet.put("register", "com.xiejun.server.demo03.LoginServlet");
	}
	
	public static Servlet getServlet(String url) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		if((null==url)||(url=url.trim()).equals("")){
			return null;
		}
		
		//return contxt.getServlet().get(contxt.getMapping().get(url));
		
		//�����ַ���(����·��)��������
		String name=contxt.getServlet().get(contxt.getMapping().get(url));
		return (Servlet)Class.forName(name).newInstance();
		
	}
}
