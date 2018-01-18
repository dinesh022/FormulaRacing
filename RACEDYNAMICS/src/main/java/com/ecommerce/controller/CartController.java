package com.ecommerce.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ecommerce.dao.CartDAO;
import com.ecommerce.dao.ProductDao;
import com.ecommerce.model.Cart;
import com.ecommerce.model.Product;

@Controller
public class CartController {
	
	
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	CartDAO cartDAO;
	
	
	
	
	@RequestMapping("addToCart/{id}")
	public String AddProductTocart(@PathVariable("id")int id)

	{
		System.out.println("welcome cart moduel.........................");
		Principal principal=SecurityContextHolder.getContext().getAuthentication();
		
		Product product=productDao.getProductById(id);
		
		Cart cart=new Cart();
		cart.setPid(product.getProductId());
		cart.setPname(product.getProductName());
		cart.setPrice(product.getProductPrice());
		cart.setQuantity(1);
		cart.setUseremail(principal.getName());
		cartDAO.saveorupdate(cart);
		return "cart";
		
	}
	
	
	@RequestMapping("customer/cart")
	public String viewCart(Model model)

	{
		Principal principal=SecurityContextHolder.getContext().getAuthentication();
		
		List<Cart>Listcart=cartDAO.listCart(principal.getName());
		
		model.addAttribute("Listcart", Listcart);
		return "cart";
		
	}
	

}
