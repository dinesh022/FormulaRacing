package com.ecommerce.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.model.Category;
import com.ecommerce.model.Users;
@Repository
@Transactional
public class UserDaoimpl implements UserDao {

	@Autowired	
	private SessionFactory sessionFactory;
		@Override
		public boolean saveUser(Users users) {
			// TODO Auto-generated method stub
			Session session = sessionFactory.getCurrentSession();
		     session.saveOrUpdate(users);
		     session.flush();
			return true;
		}

		@Override
		public List<Users> getAllUsers() {
			// TODO Auto-generated method stub
			Session session = sessionFactory.getCurrentSession();	
			Query query = session.createQuery("from Users");
			@SuppressWarnings("unchecked")
			List<Users>users = query.list();
			session.flush();
			return users;
			
		}

		@Override
		public Users getUserById(int id) {
			Session session = sessionFactory.getCurrentSession();
			Users user = (Users) session.get(Users.class,id);
			System.out.println("Customer ID:"+user.getCustomerId());
			return user;
		}
		
		@Override
		public Users getUserByeName(String username){
			Session session = sessionFactory.getCurrentSession();
			Users user = (Users) session.get(Users.class,username);
			System.out.println("User Email:"+user.getUseremail());
			return user;
		}
		
	
		
		}
