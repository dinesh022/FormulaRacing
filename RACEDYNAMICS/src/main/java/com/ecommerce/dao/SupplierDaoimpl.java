package com.ecommerce.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.model.Supplier;
@Repository
@Transactional
public class SupplierDaoimpl implements SupplierDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(supplier);
		session.flush();

	}

	@Override
	public Supplier getSupplierById(int sid) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Supplier supplier = (Supplier) session.get(Supplier.class,sid);
		return supplier;
		
	}

	@Override
	public List<Supplier> getAllSupplier() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Supplier");
		@SuppressWarnings("unchecked")
		List<Supplier> listsupplier = query.list();
		session.flush();
		return listsupplier;
		
	}

	@Override
	public void deleteSupplier(int sid) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.delete(getSupplierById(sid));
		session.flush();

	}

}
