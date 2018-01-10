package com.ecommerce.dao;

import java.util.List;

import com.ecommerce.model.Cart;

public interface CartDao {


	public boolean saveProductToCart(Cart cart);
	
	public Cart getitem(int productId,int customerId);
	
	public List<Cart>listCart();
	public boolean removeCartById(int cartId);
	
	public long cartsize(int customerId) ;
	
	public double CartPrice(int customerId) ;
	
	//public Cart editCartById(int cartId);
	public Cart getCartById(int cartId);
	
}
