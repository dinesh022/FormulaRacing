package com.niit.daoimpl;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.ProductDao;
import com.niit.model.Product;

@SuppressWarnings("deprecation")
@Repository("productDao")
public class ProductDaoImpl implements ProductDao
{
	

    @Autowired
    SessionFactory sessionFactory;
    
    
	 public ProductDaoImpl(SessionFactory sessionFactory)
	  {
		  
		  this.sessionFactory=sessionFactory;
	  
	  }


    
    
    
    @Transactional
	@Override
	public boolean addProduct(Product product) {
		 try
	        {
	            sessionFactory.getCurrentSession().saveOrUpdate(product);
	            return true;
	        }
	        catch(Exception e)
	        {
	        	System.out.println(e.getMessage());
	        return false;
	        }
	}
    
    
    
    @Transactional
	@Override
	public List<Product> retrieveProduct()
	{
		
		 Session session=sessionFactory.openSession();
	        @SuppressWarnings("rawtypes")
	        Query query=session.createQuery("from Product");
	        @SuppressWarnings("unchecked")
	        List<Product> listProduct=query.list();
	        session.close();
	        return listProduct;

	}

    

    @Transactional
	@Override
	public Product deleteProduct(int productId) 
	{
    		Product ProductToDelete = new Product();
    		ProductToDelete.setProductId(productId);
			sessionFactory.getCurrentSession().delete(ProductToDelete);
			return ProductToDelete;
		
	}
	
    
    @Transactional
	@Override
	public boolean updateProduct(Product product) 
    {
		
		 try
	        {
	        sessionFactory.getCurrentSession().saveOrUpdate(product);
	        return true;
	        }
	        catch(Exception e)
	        {
	        System.out.println("Exception Arised:"+e);
	        return false;
	        }
	    
	
	}

    
    @Transactional
	@Override
	public Product getProduct(int productid)
    {
		// TODO Auto-generated method stub
		String hql = "from"+" Product"+" where id=" + productid;
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Product> listProduct = (List<Product>) query.list();
		
		if (listProduct != null && !listProduct.isEmpty()) {
			return listProduct.get(0);
		}
		
	
		return null;
	
		
	}
    @Transactional
	@Override
	public Product getItem(int id) {
		Product product=sessionFactory.getCurrentSession().get(Product.class, id);

		return product;
	}
	
	

	
	
	
}
