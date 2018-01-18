package com.ecommerce.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;


public class CustomerOrder implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7687867690818030869L;

	@Id
	@GeneratedValue
	private int customerOrderId;
	
	
	
	
	
    private Customer customer;

    private String billingAddress;

	public int getCustomerOrderId() {
		return customerOrderId;
	}

	public void setCustomerOrderId(int customerOrderId) {
		this.customerOrderId = customerOrderId;
	}



	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}




}
