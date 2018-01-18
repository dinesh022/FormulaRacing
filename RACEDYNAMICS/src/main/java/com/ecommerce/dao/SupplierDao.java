package com.ecommerce.dao;

import java.util.List;

import com.ecommerce.model.Product;
import com.ecommerce.model.Supplier;

public interface SupplierDao {

	void addSupplier(Supplier supplier);
	Supplier getSupplierById(int sid);
	List<Supplier>getAllSupplier();
	void deleteSupplier(int sid);
	void editSupplier(Supplier supplier);
}
