package com.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.model.Register;

@Component
public class RegisterDaoImpl implements RegisterDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	DataSource dataSource;
	
	private static final String GET_USER_DETAILS = "select * from myusers where username=?";
	
	private static final String INSERT_USER_DETAILS = "insert into myusers (username,password,firstname,lastname,email,address,phone) values (?,?,?,?,?,?,?)";
	
	@Override
	public void insertRegisterDetails(Register register) {
		
		System.out.println("Inside Insert register details");
		
		jdbcTemplate.update(INSERT_USER_DETAILS, new Object[]{register.getUsername(),register.getPassword(), register.getFirstName(), 
				register.getLastName(), register.getEmail(), register.getLocation(), register.getPhone()});
		
	}

	@Override
	public boolean selectRegisterDetails(Register register) {
		
		System.out.println("Inside select register details");

		List<Register> reg = new ArrayList<Register>();
		try{
			reg = jdbcTemplate.query(GET_USER_DETAILS, new Object[]{register.getUsername()}, new RowMapper<Register>(){
	
				@Override
				public Register mapRow(ResultSet resultSet, int arg1) throws SQLException {
					
					Register usr = new Register();
					usr.setUsername(resultSet.getString("username"));
					usr.setFirstName(resultSet.getString("firstname"));
					usr.setLastName(resultSet.getString("lastname"));
					usr.setEmail(resultSet.getString("email"));
					usr.setPhone(resultSet.getString("phone"));
					usr.setLocation(resultSet.getString("address"));
					
					return usr;
				}
			});
			
			if(reg.size()>0){
				return true;
			}else{
				return false;
			}
			
		}catch (EmptyResultDataAccessException e) {
			return true;
		}
		
	}

}
