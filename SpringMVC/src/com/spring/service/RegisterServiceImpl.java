package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.dao.RegisterDaoImpl;
import com.spring.model.Register;

@Component
public class RegisterServiceImpl implements RegisterService{
	
	@Autowired
	RegisterDaoImpl registerDao;
	
	@Override
	public String insertRegisterDetials(Register register) {
		
		boolean exist;
		String status="";
		
		exist = registerDao.selectRegisterDetails(register);
		
		if(!exist){
			registerDao.insertRegisterDetails(register);
			status = "User Details Registered";
		}else{
			status = "User Details Already exists";
		}
		
		return status;
	}

}
