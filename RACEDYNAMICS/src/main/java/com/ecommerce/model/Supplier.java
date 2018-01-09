package com.ecommerce.model;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Supplier {
	@Id
    @GeneratedValue
    @Column(name="sid")
	private int sid;
	private String supplierName;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "supplier", cascade = CascadeType.ALL)
	private Set<Product>products= new HashSet<Product>();
	
	
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}

	
	
	

}
