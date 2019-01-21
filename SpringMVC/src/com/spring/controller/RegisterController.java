package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.model.Register;
import com.spring.service.RegisterServiceImpl;

@Controller
public class RegisterController {
	
	@Autowired
	RegisterServiceImpl serviceImpl;
	
	@RequestMapping("/register.htm")
	public String register(Register register){
		
		System.out.println("Inside Register");
		return "register";
	}
	
	@RequestMapping(value="register.htm", method=RequestMethod.POST)
	public String register(Model model, @ModelAttribute("register") Register register){
		
		String status="";
		
		System.out.println("Inside Register Contoller");
		
		status = serviceImpl.insertRegisterDetials(register);
		
		model.addAttribute("status", status);

		return "register";
	}

}
