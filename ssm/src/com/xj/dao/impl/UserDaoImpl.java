package com.xj.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xj.dao.UserDao;
import com.xj.vo.User;

@Repository("UserDao")
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {
	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	@Override
	public List<User> list() {
		return getSqlSession().selectList("com.xj.vo.user.mapper.list");
	}

	@Override
	public User login(User user) {
		return getSqlSession().selectOne("com.xj.vo.user.mapper.login", user);
	}

}
