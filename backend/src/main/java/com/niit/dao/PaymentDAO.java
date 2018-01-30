package com.niit.dao;

import java.util.List;

import com.niit.model.Payment;

public interface PaymentDAO {
	
	public boolean savePaymentInfo(Payment payment);

	public Payment getPaymentInfo(int paymentId);
	
	public List<Payment> getUserPaymentInfo(int userId);
	
	public List<Payment> getUserCardPaymentInfo(int userId);
	
}


