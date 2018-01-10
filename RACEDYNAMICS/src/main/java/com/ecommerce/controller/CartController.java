package com.ecommerce.controller;
	
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ecommerce.dao.CartDao;
import com.ecommerce.dao.ProductDao;
import com.ecommerce.model.Cart;
import com.ecommerce.model.Product;

	

	@Controller
	public class CartController {
		
		
		
		@Autowired
		CartDao cartDao;
		
		@Autowired
		ProductDao productDao;
		

		
		
	    @RequestMapping(value="addToCart/{id}")
	    public String addProductToCart(@PathVariable("id") int id, HttpSession session,Model model,RedirectAttributes attributes)
	    {
	    	int customerId = (Integer) session.getAttribute("customerId");
	    	int q=1;
	    	if (cartDao.getitem(id, customerId) != null) {
				Cart item = cartDao.getitem(id, customerId);
				
				item.setProductQuantity(item.getProductQuantity() + q);
				
				Product p = productDao.getProductById(id);
				
				System.out.println(item);
				item.setProductPrice(p.getProductPrice());
				item.setTotal(item.getProductQuantity() *p.getProductPrice());
				cartDao.saveProductToCart(item);
				attributes.addFlashAttribute("ExistingMessage",  p.getProductName() +"is already exist");
		
				return "redirect:/";
			} else {
				Cart item = new Cart();
				Product p = productDao.getProductById(id);
				item.setProductId(p.getProductId());
				item.setProductName(p.getProductName());
				item.setCustomerId(customerId);
				item.setProductQuantity(q);
				item.setStatus("C");
				item.setTotal(q * p.getProductPrice());
				item.setProductPrice(p.getProductPrice());
				cartDao.saveProductToCart(item);
				attributes.addFlashAttribute("SuccessMessage", "Item"+p.getProductName()+" has been deleted Successfully");
				return "redirect:/";
			}
	    	
	    }




	    @RequestMapping("viewcart")
		public String viewCart(Model model, HttpSession session) {
	    	
			
			model.addAttribute("CartList", cartDao.listCart());
			 if(cartDao.cartsize((Integer) session.getAttribute("customerId"))!=0){
				
				model.addAttribute("CartPrice", cartDao.CartPrice((Integer) session.getAttribute("customerId")));
			} else {
				model.addAttribute("EmptyCart", "true");
			}
			model.addAttribute("IfViewCartClicked", "true");
		
			return "Cart";
		}



	/*	@RequestMapping("editCart/{cartid}")
		public String editorder(@PathVariable("cartid") int cartid, @RequestParam("quantity") int q, HttpSession session) {
		
			
			Cart cart = cartDao.editCartById(cartid);
			Product p = productDao.getProductById(cart.getProductId());
			cart.setProductQuantity(q);
			
			cart.setTotal(q * p.getProductPrice());
			cartDao.saveProductToCart(cart);
			session.setAttribute("cartsize", cartDao.cartsize((Integer) session.getAttribute("customerId")));
			return "redirect:/viewcart";
		}
	   */ 
	    
	    
	    
	@RequestMapping(value="removeCart/{id}")
	public String deleteorder(@PathVariable("id") int id, HttpSession session) {
		cartDao.removeCartById(id);
		session.setAttribute("cartsize", cartDao.cartsize((Integer) session.getAttribute("customerId")));
		return "redirect:/viewcart";
	}


	@RequestMapping("continue_shopping")
	public String continueshopping()
	{
	return "redirect:/";	

	}




	}

