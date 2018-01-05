package com.ecommerce.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Supplier {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int sid;
	private String supplierName;
	private String supplierAddress;
	@OneToMany(mappedBy = "supplier", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Supplier>supplier;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	
	public String getSupplierAddress() {
		return supplierAddress;
	}
	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}
	public List<Supplier> getSupplier() {
		return supplier;
	}
	public void setsupplier(List<Supplier> supplier) {
		this.supplier = supplier;
	}

}
