package com.spring.dao;

import com.spring.model.User;

public interface LoginDao {
	
	public boolean validateLogin(User user);
	public User userDetails(User user);

}
