package com.ecommerce.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.model.Cart;
@Repository
@Transactional
public class CartDaoimpl implements CartDao {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public boolean saveProductToCart(Cart cart) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(cart);
		return true;
	}

	@Override
	public Cart getitem(int productId, int customerId) {
		// TODO Auto-generated method stub
		String hql = "from"+" Cart"+" where customerId="+customerId+" and productId="+productId;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Cart> list = (List<Cart>) query.list();
		if (list!= null && !list.isEmpty()) {
			return list.get(0);
		}
			return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cart> listCart() {
		// TODO Auto-generated method stub
		List<Cart> cartList= sessionFactory.getCurrentSession().createQuery("from Cart").list();
		return cartList;
		
	}

	@Override
	public boolean removeCartById(int cartId) {
		 Object persistentInstance =sessionFactory.getCurrentSession().load(Cart.class, cartId);
		    if (persistentInstance != null) {
		    	sessionFactory.getCurrentSession().delete(persistentInstance);
		        return true;
		    }
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long cartsize(int customerId) {
		// TODO Auto-generated method stub
		Criteria c=sessionFactory.getCurrentSession().createCriteria(Cart.class);
		c.add(Restrictions.eq("customerId", customerId));
		c.add(Restrictions.eq("status","C"));
		c.setProjection(Projections.count("customerId"));
		long count= (Long) c.uniqueResult();
		return count;
		
	}

	@Override
	public double CartPrice(int customerId) {
		// TODO Auto-generated method stub
		Criteria c=sessionFactory.getCurrentSession().createCriteria(Cart.class);
		c.add(Restrictions.eq("customerId", customerId));
		c.add(Restrictions.eq("status","C"));
		c.setProjection(Projections.sum("Total"));
		double l=  (Double) c.uniqueResult();
		return l;
	}



	/*@Override
	public Cart editCartById(int cartId) {
		
		Cart cart=	sessionFactory.getCurrentSession().get(Cart.class,cartId);
			
			return cart;
		}*/
				

	@Override
	public Cart getCartById(int cartId) {
		// TODO Auto-generated method stub
		String hql = "from"+" Cart"+" where id=" + cartId;

		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		

		@SuppressWarnings("unchecked")
		List<Cart> listCart = (List<Cart>) query.list();
		
		if (listCart != null && !listCart.isEmpty()) {
			return listCart.get(0);
		}
		
		return null;
	}

}
