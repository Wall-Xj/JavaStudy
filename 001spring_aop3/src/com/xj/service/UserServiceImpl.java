package com.xj.service;

public class UserServiceImpl implements UserService{

	@Override
	public void add(String name) {
		System.out.println("添加："+name);
		
	}

	@Override
	public void delete() {
		System.out.println("删除操作");
		
	}

}
