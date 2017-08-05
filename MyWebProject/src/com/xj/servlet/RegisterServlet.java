package com.xj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@SuppressWarnings("all")
public class RegisterServlet extends HttpServlet {
	
	public RegisterServlet() {
		
	}
	
	@Override
	public void init() throws ServletException {
		
		super.init();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Enumeration enu=req.getHeaderNames();
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<HTML>");
		out.println("<HEAD></HEAD>");
		out.println("<BODY>");
		out.println("<TABLE>");
		out.println("<TR>");
		out.println("<TH>");
		out.println("HeaderName");
		out.println("</TH>");
		out.println("<TH>");
		out.println("HeaderValue");
		out.println("</TH>");
		out.println("</TR>");
		
		while(enu.hasMoreElements()) {
			String headerName=(String)enu.nextElement();
			String headerValue=req.getHeader(headerName);
			out.println("<TR>");
			out.println("<Td>");
			out.println(headerName);
			out.println("</Td>");
			out.println("<Td>");
			out.println(headerValue);
			out.println("</Td>");
			out.println("</TR>");
		}
		
		out.println("</TABLE>");
		out.println("<BODY>");
		out.println("</HTML>");
		
		out.flush();
		out.close();
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		String pwd=req.getParameter("pwd");
		
		if(name.equals("tom")) {
//			req.getRequestDispatcher("/Test.html").forward(req, resp);
			req.getRequestDispatcher("/servlet/hello").forward(req, resp);
		}else {
			resp.sendRedirect("http://www.baidu.com");
		}
		
	}
	
}
