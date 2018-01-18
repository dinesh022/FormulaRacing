package com.ecommerce.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.dao.CategoryDao;
import com.ecommerce.dao.ProductDao;
import com.ecommerce.dao.SupplierDao;
import com.ecommerce.model.Category;
import com.ecommerce.model.Product;
import com.ecommerce.model.Supplier;


@Controller
public class AdminController {
	
	private Path path;

	 @Autowired
	 private ProductDao productDao;
	 
	 @Autowired
	 private SupplierDao supplierDao;
	 
	 @Autowired
	 private CategoryDao categoryDao;

	private int id;
	 
	 
	 // product controller
	 
	 @RequestMapping(value="/productList",method=RequestMethod.GET)
		public String getProducts(Model model){
			List<Product>products = productDao.getAllProducts();
			model.addAttribute("products", products);
			return "productList";
					
		}

	    @RequestMapping(value="/productList/viewproduct/{productId}",method=RequestMethod.GET)
	    public String viewproduct(@PathVariable int productId, Model model)
	    {
	    	
			model.addAttribute("ListProduct", productDao.getAllProducts());
	    	model.addAttribute("product",productDao.getProductById(id));
	  
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
	    	
	    	product.setProductCondition("New");
	    	product.setProductStatus("Available");
	    	List<Category>listcategory = categoryDao.getAllCategory();
	    	model.addAttribute("listcategory", listcategory);
	    	List<Supplier>listsupplier= supplierDao.getAllSupplier();
	    	model.addAttribute("listsupplier", listsupplier);
	    
	    
	    	model.addAttribute("product",product);
	    	return "AddProduct";
	    }

	    
	    @RequestMapping(value="/admin/productInventory/AddProduct", method = RequestMethod.POST)
	    public String addProductPost(@Valid @ModelAttribute("product")Product product, BindingResult result, HttpServletRequest request){
	    	if(result.hasErrors()){
	    		return "AddProduct";
	    	}
	    	productDao.addProduct(product);
	    	
	    	MultipartFile productImage = product.getProductImage();
	    	String rootDirectory = request.getSession().getServletContext().getRealPath("/");
	    	path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\"+product.getProductId()+".jpg");
	    	
	    	if(productImage !=null && !productImage.isEmpty()){
	    		try{
	    			productImage.transferTo(new File(path.toString()));
	    		} catch (Exception e){
	    			e.printStackTrace();
	    	       throw new RuntimeException("Product image failed", e);
	    	       
	    		}
	    	}
	    	return "redirect:/admin/productInventory";
	}
	    
	    
	    
	    @RequestMapping("/admin/productInventory/deleteProduct/{id}")
	    public String deleteProduct(@PathVariable int id, Model model, HttpServletRequest request){
	    	String rootDirectory = request.getSession().getServletContext().getRealPath("/");
	    	path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images"+id+".jpg");
	    	
	    	if(Files.exists(path)){
	    		try{
	    			Files.delete(path);
	    		} catch(IOException e){
	    			e.printStackTrace();
	    		}
	    	}productDao.deleteProduct(id);
	    	
	    	return "redirect:/admin/productInventory";
	    }
         
	    @RequestMapping("/admin/productInventory/editProduct/{id}")
	    public String editProduct(@PathVariable("id") int id, Model model){
	    	Product product = productDao.getProductById(id);
	    	product.setProductCondition("New");
	    	product.setProductStatus("Available");
	    	List<Category>listcategory = categoryDao.getAllCategory();
	    	model.addAttribute("listcategory", listcategory);
	    	List<Supplier>listsupplier= supplierDao.getAllSupplier();
	    	model.addAttribute("listsupplier", listsupplier);
	    	model.addAttribute(product);
	    	return "editProduct";
	    }
	    
	    @RequestMapping(value="/admin/productInventory/editProduct", method = RequestMethod.POST)
	    public String editProduct(@Valid @ModelAttribute("product")Product product, Model model, BindingResult result, HttpServletRequest request){
	    	if(result.hasErrors()){
	    		return "editProduct";
	    	}
	    	productDao.editProduct(product);
	    	MultipartFile productImage = product.getProductImage();
	    	String rootDirectory = request.getSession().getServletContext().getRealPath("/");
	    	path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images"+product.getProductId()+".jpg");
	    	
	    	if(productImage !=null && !productImage.isEmpty()){
	    		try{
	    			productImage.transferTo(new File(path.toString()));
	    		} catch (Exception e){
	    			e.printStackTrace();
	    	       throw new RuntimeException("Product image failed", e);
	    	       
	    		}
	    	}
	    
	    	
	    	return "redirect:/admin/productInventory";
	}
	    
	    
  //category controller
	    
	   

	    @RequestMapping("/admin/categoryInventory")
	    public String categoryInventory(Model model){
	    	List<Category>listcategory = categoryDao.getAllCategory();
	    	model.addAttribute("listcategory", listcategory);
	    	return "categoryInventory";
	    }


	    @RequestMapping("/admin/categoryInventory/AddCategory")
	    public String AddCategory(Model model){
	    	Category category = new Category();
	    	
	    	model.addAttribute("category",category);
	    	return "AddCategory";
	    }

	    
	    @RequestMapping(value="/admin/categoryInventory/AddCategory", method = RequestMethod.POST)
	    public String addCategoryPost(@ModelAttribute("category")Category category){
	    	categoryDao.addCategory(category);
	    	return "redirect:/admin/categoryInventory";
	}

        
	    @RequestMapping("/admin/categoryInventory/deleteCategory/{cid}")
	    public String deleteCategory(@PathVariable int cid, Model model){
	    	categoryDao.deleteCategory(cid);
	    	return "redirect:/admin/categoryInventory";
	    }
         
	    @RequestMapping("/admin/categoryInventory/editCategory/{cid}")
	    public String editCategory(@PathVariable("cid") int cid, Model model){
	    	Category category = categoryDao.getCategoryById(cid);
	    	model.addAttribute(category);
	    	return "editCategory";
	    } 
	    
	    @RequestMapping(value="/admin/categoryInventory/editCategory", method = RequestMethod.POST)
	    public String editCategory(@Valid @ModelAttribute("category")Category category, Model model){
	    	categoryDao.editCategory(category);
	    	return "redirect:/admin/categoryInventory";
	    	}

     //supplier controller
	    
	    
	    @RequestMapping("/admin/supplieradmin")
	    public String supplieradminPage(){
	    	return "supplieradmin";
	    }

	    @RequestMapping("/admin/supplierInventory")
	    public String supplierInventory(Model model){
	    	List<Supplier>listsupplier = supplierDao.getAllSupplier();
	    	model.addAttribute("listsupplier", listsupplier);
	    	return "supplierInventory";
	    }


	    @RequestMapping("/admin/supplierInventory/AddSupplier")
	    public String AddSupplier(Model model){
	    	Supplier supplier = new Supplier();
	    	
	        model.addAttribute("supplier",supplier);
	    	return "AddSupplier";
	    }

	    
	    @RequestMapping(value="/admin/supplierInventory/AddSupplier", method = RequestMethod.POST)
	    public String addSupplierPost(@ModelAttribute("supplier")Supplier supplier){
	    	supplierDao.addSupplier(supplier);
	    	return "redirect:/admin/supplierInventory";
	}

        
	    @RequestMapping("/admin/supplierInventory/deleteSupplier/{sid}")
	    public String deleteSupplier(@PathVariable int sid, Model model){
	    	supplierDao.deleteSupplier(sid);
	    	return "redirect:/admin/supplierInventory";
	    }

	    @RequestMapping("/admin/supplierInventory/editSupplier/{sid}")
	    public String editSupplier(@PathVariable("sid") int sid, Model model){
	    	Supplier supplier = supplierDao.getSupplierById(sid);
	    	model.addAttribute(supplier);
	    	return "editSupplier";
	    } 
	    
	    @RequestMapping(value="/admin/supplierInventory/editSupplier", method = RequestMethod.POST)
	    public String editSupplier( @ModelAttribute("supplier")Supplier supplier, Model model){
	    	supplierDao.editSupplier(supplier);
	    	return "redirect:/admin/supplierInventory";
	    	}
	    
	  }
