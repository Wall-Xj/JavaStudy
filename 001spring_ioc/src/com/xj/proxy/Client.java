package com.xj.proxy;

import com.xj.service.UserService;
import com.xj.service.UserServiceImpl;

public class Client {
	public static void main(String[] args) {
		UserService userService = new UserServiceImpl();
		ProxyInocationHandler pih=new ProxyInocationHandler();
		pih.setTarget(userService);
		UserService proxy=(UserService)pih.getProxy();
		proxy.add("张三");
	}
}
