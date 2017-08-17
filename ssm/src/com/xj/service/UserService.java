package com.xj.service;

import java.util.List;

import com.xj.vo.User;

public interface UserService {
	public List<User> list();
	
	public User login(User user);
}
