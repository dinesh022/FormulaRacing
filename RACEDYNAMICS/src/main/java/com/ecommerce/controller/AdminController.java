package com.ecommerce.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ecommerce.dao.CategoryDao;
import com.ecommerce.dao.ProductDao;
import com.ecommerce.dao.SupplierDao;
import com.ecommerce.model.Category;
import com.ecommerce.model.Product;
import com.ecommerce.model.Supplier;

@Controller
public class AdminController {

	 @Autowired
	 private ProductDao productDao;
	 
	 @Autowired
	 private SupplierDao supplierDao;
	 
	 @Autowired
	 private CategoryDao categoryDao;
	 
	 
	 // product controller
	 
	 @RequestMapping("/productList")
		public String getProducts(Model model){
			List<Product>products = productDao.getAllProducts();
			model.addAttribute("products", products);
			return "productList";
					
		}

	    @RequestMapping("/productList/viewproduct/{productId}")
	    public String viewproduct(@PathVariable String productId, Model model)throws IOException{
	    	Product product = productDao.getProductById(productId);
	    	model.addAttribute(product);
	    	return "viewproduct";
	    }

	    @RequestMapping("/admin")
	    public String adminPage(){
	    	return "admin";
	    }

	    @RequestMapping("/admin/productInventory")
	    public String productInventory(Model model){
	    	List<Product>products = productDao.getAllProducts();
	    	model.addAttribute("products", products);
	    	return "productInventory";
	    }

	    @RequestMapping("/admin/productInventory/AddProduct")
	    public String AddProduct(Model model){
	    	Product product = new Product();
	    	
	    	
	    	model.addAttribute("product",product);
	    	return "AddProduct";
	    }

	    
	    @RequestMapping(value="/admin/productInventory/AddProduct", method = RequestMethod.POST)
	    public String addProductPost(@ModelAttribute("product")Product product){
	    	productDao.addProduct(product);
	    	return "redirect:/admin/productInventory";
	}
	    
	    
	    
	    @RequestMapping("/admin/productInventory/deleteProduct{id}")
	    public String deleteProduct(@PathVariable String id, Model model){
	    	productDao.deleteProduct(id);
	    	return "redirect:/admin/productInventory";
	    }

  //category controller
	    
	    @RequestMapping("/categoryadmin")
	    public String categoryadminPage(){
	    	return "categoryadmin";
	    }

	    @RequestMapping("/categoryadmin/categoryInventory")
	    public String categoryInventory(Model model){
	    	List<Category>listcategory = categoryDao.getAllCategory();
	    	model.addAttribute("category", listcategory);
	    	return "categoryInventory";
	    }


	    @RequestMapping("/categoryadmin/categoryInventory/AddCategory")
	    public String AddCategory(Model model){
	    	Category category = new Category();
	    	
	        model.addAttribute("category",category);
	    	return "AddCategory";
	    }

	    
	    @RequestMapping(value="/categoryadmin/categoryInventory/AddCategory", method = RequestMethod.POST)
	    public String addCategoryPost(@ModelAttribute("category")Category category){
	    	categoryDao.addCategory(category);
	    	return "redirect:/categoryadmin/categoryInventory";
	}

        
	    @RequestMapping("/categoryadmin/categoryInventory/deleteCategory{cid}")
	    public String deleteCategory(@PathVariable int cid, Model model){
	    	supplierDao.deleteSupplier(cid);
	    	return "redirect:/categoryadmin/categoryInventory";
	    }


     //supplier controller
	    
	    
	    @RequestMapping("/supplieradmin")
	    public String supplieradminPage(){
	    	return "supplieradmin";
	    }

	    @RequestMapping("/supplieradmin/supplierInventory")
	    public String supplierInventory(Model model){
	    	List<Supplier>listsupplier = supplierDao.getAllSupplier();
	    	model.addAttribute("supplier", listsupplier);
	    	return "supplierInventory";
	    }


	    @RequestMapping("/supplieradmin/supplierInventory/AddSupplier")
	    public String AddSupplier(Model model){
	    	Supplier supplier = new Supplier();
	    	
	        model.addAttribute("supplier",supplier);
	    	return "AddSupplier";
	    }

	    
	    @RequestMapping(value="/supplieradmin/supplierInventory/AddSupplier", method = RequestMethod.POST)
	    public String addSupplierPost(@ModelAttribute("supplier")Supplier supplier){
	    	supplierDao.addSupplier(supplier);
	    	return "redirect:/supplieradmin/supplierInventory";
	}

        
	    @RequestMapping("/supplieradmin/supplierInventory/deleteSupplier{sid}")
	    public String deleteSupplier(@PathVariable int sid, Model model){
	    	supplierDao.deleteSupplier(sid);
	    	return "redirect:/supplieradmin/supplierInventory";
	    }

	  }
