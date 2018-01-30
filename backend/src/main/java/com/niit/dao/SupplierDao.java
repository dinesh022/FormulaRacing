package com.niit.dao;

import java.util.List;

import com.niit.model.Supplier;

public interface SupplierDao
{
	public boolean addSupplier(Supplier supplier);
	public List<Supplier> retrieveSupplier();
	public Supplier deleteSupplier(int supplier_id);
	public Supplier getSupplier(int supplierId);
	public boolean updateSupplier(Supplier supplier);

}
