package com.xiejun.server.demo01;

public class Servlet {
	public void service(Request req,Response rep){
		rep.println("<html><head><title>HTTP��Ӧʾ��</title>");
		rep.println("</head><body>");
		rep.println("��ӭ��").println(req.getParameter("name")).println("����");
		rep.println("</body></html>");
	}

}
