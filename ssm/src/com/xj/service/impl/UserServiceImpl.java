package com.xj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xj.dao.UserDao;
import com.xj.service.UserService;
import com.xj.vo.User;

@Service("UserService")
public class UserServiceImpl  implements UserService{
	@Autowired
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public List<User> list() {
	
		return userDao.list();
	}

	@Override
	public User login(User user) {
		return userDao.login(user);
	}
	
}
