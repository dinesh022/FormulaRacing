package com.ecommerce.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.model.Authorities;
import com.ecommerce.model.Customer;
import com.ecommerce.model.Users;

@Repository
@Transactional
public class CustomerDaoimpl implements CustomerDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);
      
		Users newUser = new Users();
		newUser.setUseremail(customer.getUseremail());
		newUser.setPassword(customer.getPassword());
		newUser.setEnabled(true);
		newUser.setCustomerId(customer.getCustomerId());
		
		
		Authorities newAuthority = new Authorities();
		newAuthority.setUseremail(customer.getUseremail());
		newAuthority.setAuthority("ROLE_USER");
		session.saveOrUpdate(newUser);
		session.saveOrUpdate(newAuthority);
		
		session.flush();
	}
    
	public Customer getCustomerById(int customerId){
		Session session = sessionFactory.getCurrentSession();
		return(Customer) session.get(Customer.class, customerId);
	}

	public List<Customer> getAllCustomers(){
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Customer");
		List<Customer> listcustomer = query.list();
		return listcustomer;
	}
	
}
