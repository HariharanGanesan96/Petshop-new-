package com.petinterface;

import com.petclass.Customers;

public interface CustomerInterface {

	public void insert(Customers cus);
	
	public void update(Customers cus);
	
	public void updateAddressDetails(Customers cus);
	
	public void delete(Customers customer);
	
	public String cusValidation(Customers cus);
	
	public boolean ValidateEmail(String cus);
	
	public void showCustomerList();
	
	public Customers customerDetails(String userName);
		
	public void updateImage(Customers cus);
	
	
	
	
	
}
