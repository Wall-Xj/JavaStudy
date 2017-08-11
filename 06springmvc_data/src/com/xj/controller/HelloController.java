package com.xj.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xj.vo.User;

@Controller
public class HelloController {
	
	

	public HelloController() {
		System.out.println("hello constructor");
	}

	@RequestMapping("/hello")
	public String hello(@RequestParam("uname")String name,ModelMap model) throws Exception {
		System.out.println(name);
		model.addAttribute("msg",name);
		return "forward:index.jsp";
	}
	
	@RequestMapping("/user")
	public String user(User user) {
		System.out.println(user);
		return "index.jsp";
	}
	
}
