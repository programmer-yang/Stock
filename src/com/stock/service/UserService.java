package com.stock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.dao.UserDao;
import com.stock.entity.User;
import com.stock.service.base.AbstractService;

@Service
public class UserService extends AbstractService<User, Long> {

	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.setBaseDao(userDao);
		this.userDao = userDao;
	}



	public User findByUserName(User user)
	{
		return userDao.findByUserName(user);
	}
	
}
