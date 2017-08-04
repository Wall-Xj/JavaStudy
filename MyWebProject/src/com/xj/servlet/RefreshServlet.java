package com.xj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RefreshServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setIntHeader("Refresh", 3);
		
		resp.setContentType("text/html;charset=UTF-8");
		
		
		
		String title = "自动刷新 Header 设置 - 菜鸟教程实例";
	      String docType ="<!DOCTYPE html>\n";
	      PrintWriter out = resp.getWriter();
	      String nowTime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis()));
	      out.println(docType +
	        "<html>\n" +
	        "<head><title>" + title + "</title></head>\n"+
	        "<body bgcolor=\"#f0f0f0\">\n" +
	        "<h1 align=\"center\">" + title + "</h1>\n" +
	        "<p>当前时间是：" + nowTime + "</p>\n");
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
