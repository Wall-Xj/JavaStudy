package com.xj.dao;

import java.util.List;

import com.xj.vo.User;

public interface UserDao {
	public List<User> list();
	
	public User login(User user);
}
