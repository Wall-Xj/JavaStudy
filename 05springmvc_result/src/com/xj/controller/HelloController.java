package com.xj.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public void hello(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//不需要视图解析器
		resp.getWriter().println("hello spring mvc use httpservlet api");
		
	}
	
	@RequestMapping("/hello1")
	public void hello1(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//不需要视图解析器
		resp.sendRedirect("index.jsp");
		
	}
	
	@RequestMapping("/hello2")
	public void hello2(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//不需要视图解析器
		req.setAttribute("msg", "servlet api forword");
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
	
	@RequestMapping("/test")
	public String  test() {
		//不需要视图解析器
		return "redirect:index.jsp";
	}
	
	@RequestMapping("/test1")
	public String  test1() {
		//不需要视图解析器
		return "forward:index.jsp";
	}
	
	@RequestMapping("/temp")
	public String temp() {
		return "hello";
	}
	
	@RequestMapping("/temp1")
	public String temp1() {
		return "redirect:hello.do";
	}
	
}
