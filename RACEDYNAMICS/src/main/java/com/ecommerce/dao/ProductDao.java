package com.ecommerce.dao;

import java.util.List;

import com.ecommerce.model.Product;

public interface ProductDao {

	void addProduct(Product product);
	Product getProductById(int id);
	List<Product>getAllProducts();
	void deleteProduct(int id);
	void editProduct(Product product);
}
