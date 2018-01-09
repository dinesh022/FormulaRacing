package com.ecommerce.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.model.Category;

@Repository
@Transactional

public class CategoryDaoimpl implements CategoryDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addCategory(Category category) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(category);
		session.flush();
	}

	@Override
	public Category getCategoryById(int cid) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Category category = (Category) session.get(Category.class,cid);
		return category;
	}

	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Category");
		@SuppressWarnings("unchecked")
		List<Category> listcategory = query.list();
		session.flush();
		return listcategory;
		
	}

	@Override
	public void deleteCategory(int cid) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.delete(getCategoryById(cid));
		session.flush();

	}

}
