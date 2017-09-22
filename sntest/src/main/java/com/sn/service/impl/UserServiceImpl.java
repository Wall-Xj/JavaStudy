package com.sn.service.impl;

import com.sn.entity.User;
import com.sn.mapper.UserMapper;
import com.sn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;

@Service("UserService")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMappper;

    @Override
    public User login(User user) {
        return userMappper.login(user);
    }
}
