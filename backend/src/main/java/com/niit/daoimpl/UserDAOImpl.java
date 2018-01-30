package com.niit.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.UserDAO;
import com.niit.model.User;

@Repository
public class UserDAOImpl implements UserDAO
{

	@Autowired
	SessionFactory sessionFactory;
	
	public UserDAOImpl(SessionFactory SessionFactory) {
	this.sessionFactory=sessionFactory;
	
	}

	public boolean saveUser(User user)
	{
	
		Session session=sessionFactory.openSession();
		session.saveOrUpdate(user);
		Transaction tx=session.beginTransaction();
		tx.commit();
	    return true;
	}

	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(int user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeUserById(int user_id) {
		// TODO Auto-generated method stub
		
	}
	@SuppressWarnings("deprecation")
	@Transactional
	public User get(String email) {
		Criteria c = sessionFactory.getCurrentSession().createCriteria(User.class);
		c.add(Restrictions.eq("email", email));

		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) c.list();

		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		} else {
			return null;
		}

	}



}
