package com.petinterface;

import com.model.Customers;

public interface CustomerInterface {

	public void insert(Customers cus);
	
	public void update(Customers cus);
	
	public void delete(Customers customer);
	
	public String cusValidation(Customers cus);
	
	public boolean ValidateEmail(String cus);
	
	public void showCustomerList();
	
	public Customers customerDetails(String userName);
	
	public void updateBank(int cusId,long bank);
	
	public void updateFirstName(Customers cus);
	
	public void updateLastName(int cusId,String lastName);
	
	public void updateUserName(int cusId,String userName);
	
	public void updatePassword(int cusId,String password);
	
	public void updateNumber(int cusId,long number);
	
	public void updateGender(Customers cus);
	
	public void updateEmail(int cusId,String email);
	
	public void updateAddress(int cusId,String address);
	
	public void updatePincode(int cusId,int pincode);
	
	public void updateCity(int cusId,String city);
	
	public void updateImage(int cusId,String image);
	
	public void updateAddressPincode(Customers cus);
	
	
	
	
}
