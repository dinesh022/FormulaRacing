package com.ecommerce.model;



import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;




@Entity
public class Product implements Serializable {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 6151716826336633616L;

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int productId;
  
    @NotEmpty (message= "The product name must not be empty.")
	private String productName;
	
	private String productDescription;
	@Min(value=0, message= "The product price must not be less than zero.")
	private double productPrice;
	private String productCondition;
	private String productStatus;
	@Min(value=0,message= "The product stock must not be less than zero.")
	private int unitinStock;
    private String productManufacturer;
    private int cid;
	private int sid;
    
    @Transient
    private MultipartFile productImage;    
    
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cid", updatable = false, insertable = false, nullable = false)
	private Category category;
	 
	 
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "sid", nullable = false, updatable = false, insertable = false)
	private Supplier supplier;

	
	

  
public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
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



public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public int getSid() {
	return sid;
}
public void setSid(int sid) {
	this.sid = sid;
}
public Category getCategory() {
	return category;
}
public void setCategory(Category category) {
	this.category = category;
}
public Supplier getSupplier() {
	return supplier;
}
public void setSupplier(Supplier supplier) {
	this.supplier = supplier;
}
public MultipartFile getProductImage() {
	return productImage;
}
public void setProductImage(MultipartFile productImage) {
	this.productImage = productImage;
}








}







