package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDao;
import com.pojo.User;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	@Override
	public User login(User user) {
		User u = userDao.login(user);
		return u;
	}
	@Override
	public void register(User user) {
		// TODO Auto-generated method stub
		userDao.register(user);
	}
}
