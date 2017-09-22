package com.sn.service;

import com.sn.entity.User;
import com.sn.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


public interface UserService {

	public User login(User user);
}
