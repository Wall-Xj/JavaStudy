package com.xj.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.xj.model.User;
import com.xj.service.UserProfileService;
import com.xj.service.UserService;

@Controller
@RequestMapping("/app")
@SessionAttributes("roles")
public class AppController {
	
	@Resource
	UserService userService;
	
	@Resource
	UserProfileService userProfileService;
	
	@Resource
	MessageSource messageSource;
	
	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public List<User> listUsers(ModelMap model) {

		List<User> users = userService.findAllUsers();
		model.addAttribute("users", users);
//		model.addAttribute("loggedinuser", getPrincipal());
		return users;
	}
	
	@RequestMapping(value = { "/test" }, method = RequestMethod.GET)
	public String test() {
		return "hello ssh";
	}
}
