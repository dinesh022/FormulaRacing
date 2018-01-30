package com.niit.dao;
 
import java.util.List;
 
import com.niit.model.Category;
 
public interface CategoryDAO 
{
    public boolean addCategory(Category category);
    public List<Category> retrieveCategory();
    public  Category deleteCategory(int category_Id);
    public Category getCategory(int catId);
    public boolean updateCategory(Category category);

}