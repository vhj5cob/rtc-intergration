package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model.User;
import com.spring.service.LoginServiceImpl;

@Controller
public class LoginController {
	
	@Autowired
	LoginServiceImpl loginServiceImpl;
	
	
	ModelAndView mav=null;

	@RequestMapping("/login.htm")
	public String userLogin(User user){
		
		System.out.println("Inside Login show page");
		return "login";
	}
	
	@RequestMapping(value="/login.htm", method=RequestMethod.POST)
	public String loginProcess(@ModelAttribute("user") User user, Model model){
		
		System.out.println("Inisde Login Process");
		
		User use = new User();
		
		use = loginServiceImpl.userDetails(user);
		
		if(null != use.getUsername() && user.getPassword().equals(use.getPassword())){
			model.addAttribute("msg", "Welcome " + use.getFirstName()+" "+use.getLastName());
            return "success";
		}else{
			model.addAttribute("message", "Bad Credential");
			return "login";
		}
		/*if(loginServiceImpl.validateLogin(user)){
		model.addAttribute("msg", "Welcome " + user.getUsername());
        return "success";
		}else{
			 model.addAttribute("message", "Invalid Details");
	         return "login";
		}*/
			
		}
	
	@ExceptionHandler
	public ModelAndView exceptinoHandling(Exception e){
		
		mav = new ModelAndView();
		mav.addObject("exception",e);
		mav.setViewName("error");
		
		return mav;
	}
	
}
