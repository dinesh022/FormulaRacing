package com.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private String productId;
	private String productName;
	private String productCategory;
	private String productDescription;
	private double productPrice;
	private String productCondition;
	private String productStatus;
	private int unitinStock;
    private String productManufacturer;
    private int sid;
    private int cid;
    
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name="sid", updatable = false, insertable = false, nullable = false)
  private Supplier supplier;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="cid", updatable = false, insertable = false, nullable = false)
  private Category category;

  
public String getProductId() {
	return productId;
}
public void setProductId(String productId) {
	this.productId = productId;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public String getProductCategory() {
	return productCategory;
}
public void setProductCategory(String productCategory) {
	this.productCategory = productCategory;
}
public String getProductDescription() {
	return productDescription;
}
public void setProductDescription(String productDescription) {
	this.productDescription = productDescription;
}
public double getProductPrice() {
	return productPrice;
}
public void setProductPrice(double productPrice) {
	this.productPrice = productPrice;
}

public String getProductCondition() {
	return productCondition;
}
public void setProductCondition(String productCondition) {
	this.productCondition = productCondition;
}
public String getProductStatus() {
	return productStatus;
}
public void setProductStatus(String productStatus) {
	this.productStatus = productStatus;
}
public int getUnitinStock() {
	return unitinStock;
}
public void setUnitinStock(int unitinStock) {
	this.unitinStock = unitinStock;
}
public String getProductManufacturer() {
	return productManufacturer;
}
public void setProductManufacturer(String productManufacturer) {
	this.productManufacturer = productManufacturer;
}
public int getSid() {
	return sid;
}
public void setSid(int sid) {
	this.sid = sid;
}
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}




}







