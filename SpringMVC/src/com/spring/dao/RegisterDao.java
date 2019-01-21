package com.spring.dao;

import com.spring.model.Register;

public interface RegisterDao {
	
	public void insertRegisterDetails(Register register);
	
	public boolean selectRegisterDetails(Register register);

}
