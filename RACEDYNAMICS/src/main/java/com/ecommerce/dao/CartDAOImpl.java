package com.ecommerce.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.model.Cart;


@Repository
public class CartDAOImpl implements CartDAO {

	@Autowired
	private SessionFactory sessionFactory;

	
		public boolean saveorupdate(Cart cart) {
	
		Session session=sessionFactory.openSession();
		
		Transaction tx=session.beginTransaction();
		session.saveOrUpdate(cart);
		tx.commit();
		return true;
	}

		@Transactional
		public List<Cart> listCart(String useremail) {
			Criteria c=sessionFactory.getCurrentSession().createCriteria(Cart.class);
			c.add(Restrictions.eq("useremail", useremail));
			return c.list();
			
		
			
		}

}
