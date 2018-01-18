package com.ecommerce.controller;






import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.dao.CustomerDao;
import com.ecommerce.dao.UserDao;
import com.ecommerce.model.Customer;
import com.ecommerce.model.Users;





@Controller
public class HomeController {
	

	

	 @Autowired
	 private CustomerDao customerDao;
	 
        @RequestMapping("/")
		public String home(HttpSession session){
			return "home";
		}
		
		@RequestMapping("/Register")
		public String CustomerRegistration(Model model){
			Customer customer = new Customer();
			model.addAttribute("customer",customer);
			return "Register";
		}
		
		@RequestMapping(value="saveCustomer", method=RequestMethod.POST)
		public String CustomerRegistrationPost(@ModelAttribute("customer")Customer customer){
			customer.setEnabled(true);
			customerDao.addCustomer(customer);
			return "redirect:/";
		}
	    
		
		

		
	
	
	
	
}


