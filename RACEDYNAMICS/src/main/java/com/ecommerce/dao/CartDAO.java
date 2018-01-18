package com.ecommerce.dao;

import java.util.List;

import com.ecommerce.model.Cart;

public interface CartDAO {
	
	public boolean saveorupdate(Cart cart);
	
	public List<Cart>listCart(String useremail);

}
