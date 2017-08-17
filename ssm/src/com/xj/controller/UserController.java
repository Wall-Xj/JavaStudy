package com.xj.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xj.service.UserService;
import com.xj.vo.User;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@RequestMapping("/list")
	public String list(ModelMap map) {
		map.addAttribute("list",userService.list());

		return "/list.jsp";
	}
	
	@RequestMapping("/login")
	public String login(User user,HttpSession session) {
		User obj=userService.login(user);
		System.out.println(obj.getId());
		if(obj!=null) {
			session.setAttribute("user", obj);
			return "redirect:list.do";
		}
		return "redirect:/login.jsp";
	}
	
	@RequestMapping("/ajax")
	public void ajax(String name,HttpServletResponse resp) throws IOException {
		if(name.equals("qwer")) {
			resp.getWriter().print("true");
		}else {
			resp.getWriter().print("false");
		}
	}
	@ResponseBody
	@RequestMapping("/json")
	public List<User> json(){
		List<User> list=userService.list();
		return list;
	}
	 
	
}
