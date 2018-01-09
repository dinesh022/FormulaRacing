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
public class Category {
	@Id
    @GeneratedValue
    @Column(name="cid")
	private int cid;
	private String categoryName;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "category", cascade = CascadeType.ALL)
	 private Set<Product> products = new HashSet<Product>();
	
	 
	 public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	
	
}
