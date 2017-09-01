package com.xj.springmvc.dao;

import java.util.List;

import com.xj.springmvc.model.UserProfile;

public interface UserProfileDao {

	List<UserProfile> findAll();
	
	UserProfile findByType(String type);
	
	UserProfile findById(int id);
}
