package com.ecommerce.dao;

import java.util.List;

import com.ecommerce.model.Category;
import com.ecommerce.model.Supplier;

public interface CategoryDao {
	void addCategory(Category category);
	Category getCategoryById(int cid);
	List<Category>getAllCategory();
	void deleteCategory(int cid);
	void editCategory(Category category);
	
}
