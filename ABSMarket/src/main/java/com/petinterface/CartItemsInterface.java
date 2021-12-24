package com.petinterface;

import java.util.List;

import com.model.CartItems;
import com.model.Customers;

public interface CartItemsInterface {

	public void insert(CartItems cartit);
	
	public void updateQty(int itemId,int qty);
	
	public void delete(int itemId);
		
	public List<CartItems> show(Customers cus);
		
}
