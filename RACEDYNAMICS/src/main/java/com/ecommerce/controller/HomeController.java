package com.ecommerce.controller;






import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.ecommerce.dao.UserDao;



import com.ecommerce.model.Users;





@Controller
public class HomeController {
	

	

	 @Autowired
	 private UserDao userDao;
	 

	 

	 
	 

		@RequestMapping("/")
		public String home(){
			return "home";
		}
		
		
		
	    
		
		
		@RequestMapping(value="/Register", method=RequestMethod.GET)
		public String  toregister(Model  m)
		{
			m.addAttribute("users",new Users()) ;
			 
			 return "Register";
	}
		
		@RequestMapping(value="saveUser", method=RequestMethod.POST)
		public String createUser(@ModelAttribute("users") Users users){
			userDao.saveUser(users);
			return "redirect:/";
			
		}	
		
	
	
	
	
}


