package com.spring.service;

import com.spring.model.User;

public interface LoginService {
	
	public boolean validateLogin(User user);
	public User userDetails(User user);

}
