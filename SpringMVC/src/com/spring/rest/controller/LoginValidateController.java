package com.spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dao.LoginValidateDaoImpl;
import com.spring.model.User;

@RestController
public class LoginValidateController {
	
	@Autowired
	LoginValidateDaoImpl loginValidateDaoImpl;
	
	@RequestMapping(value="/loginValidate", method=RequestMethod.POST)
	public ResponseEntity<User> loginValidate(@RequestBody User user){
		
		System.out.println("Inside Validate Controller");
		User use = new User();
		use = loginValidateDaoImpl.loginValidate(user);
		
		return new ResponseEntity(use, HttpStatus.OK);
	}

}
