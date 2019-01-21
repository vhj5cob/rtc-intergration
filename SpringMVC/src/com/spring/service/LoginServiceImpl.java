package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.dao.LoginDaoImpl;
import com.spring.model.User;
@Component
public class LoginServiceImpl implements LoginService{

	@Autowired
	LoginDaoImpl loginDao;
	
	@Override
	public boolean validateLogin(User user) {
		
		return loginDao.validateLogin(user);
	}

	@Override
	public User userDetails(User user) {

		return loginDao.userDetails(user);
	}
	
	
}
