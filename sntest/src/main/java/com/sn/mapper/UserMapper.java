package com.sn.mapper;

import org.springframework.stereotype.Repository;

import com.sn.entity.User;

@Repository
public interface UserMapper {
	User login(User user);
}
