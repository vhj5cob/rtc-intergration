package com.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.spring.model.User;

@Component
public class LoginDaoImpl implements LoginDao{

	@Autowired
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	RestTemplate restTemplate;

	@Override
	public boolean validateLogin(User user) {
		
		System.out.println("Inside Client");
		
		String uri = "http://localhost:8082/SpringMVC/loginValidate";
		
		User use = new User();
		
		use = restTemplate.postForObject(uri, user, User.class);
		
		System.out.println("Result :"+use.getUsername());
		
		if(user.getUsername().equalsIgnoreCase(use.getUsername())){
			return true;
		}else{
			return false;	
		}	
	}

	@Override
	public User userDetails(User user) {

		System.out.println("Inside Client");
		
		String uri = "http://localhost:8082/SpringMVC/loginValidate";
		
		User use = new User();
		
		use = restTemplate.postForObject(uri, user, User.class);
		
		System.out.println("Username :"+use.getUsername());
		
		return use;
	}
	
	/*@Override
	public boolean validateLogin(User user) {

		String USER_VALIDATION = "Select * from myusers where username = ?";
		
		System.out.println("Validating Login credential");
		
		User use = new User();
		try{
			use = jdbcTemplate.queryForObject(USER_VALIDATION, new Object[]{user.getUsername()}, new RowMapper<User>(){
	
				@Override
				public User mapRow(ResultSet resultSet, int arg1) throws SQLException {
					
					User usr =  new User();
					usr.setUsername(resultSet.getString("username"));
					
					return usr;
				}
			}
			);
		}catch (EmptyResultDataAccessException e) {
			return false;
		}
		if(user.getUsername().equalsIgnoreCase(use.getUsername())){
			return true;
		}else{
			return false;	
		}	
	}*/

}
