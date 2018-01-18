package com.ecommerce.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.model.Product;
@Repository
@Transactional
public class ProductDaoimpl implements ProductDao {
@Autowired
private SessionFactory sessionFactory;
	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
		session.flush();
	
		}

	public void editProduct(Product product) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
		session.flush();
	}
	
	
	@Override
	public Product getProductById(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		Product product = (Product) session.get(Product.class,id);
		return product;
		
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Product");
		@SuppressWarnings("unchecked")
		List<Product> products = query.list();
		session.flush();
		return products;
		
		}

	@Override
	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.delete(getProductById(id));
		session.flush();
	}

}
