package com.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.model.User;

@Component
public class LoginValidateDaoImpl {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	DataSource dataSource;
	
	public User loginValidate(User user){
		
		System.out.println("Inside Validate Service");
	
		String USER_VALIDATION = "Select * from myusers where username = ?";
		
		System.out.println("Validating Login credential");
		
		User use = new User();
		try{
			use = jdbcTemplate.queryForObject(USER_VALIDATION, new Object[]{user.getUsername()}, new RowMapper<User>(){
	
				@Override
				public User mapRow(ResultSet resultSet, int arg1) throws SQLException {
					
					User usr =  new User();
					usr.setUsername(resultSet.getString("username"));
					usr.setPassword(resultSet.getString("password"));
					usr.setFirstName(resultSet.getString("firstname"));
					usr.setLastName(resultSet.getString("lastname"));
					usr.setEmail(resultSet.getString("email"));
					usr.setPhone(resultSet.getString("phone"));
					usr.setAddress(resultSet.getString("address"));
					
					return usr;
				}
			});
		}catch (EmptyResultDataAccessException e) {
			return use;
		}
		return use;
	}

}
