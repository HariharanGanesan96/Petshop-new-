package com.daointerface;

import java.util.List;

import com.model.Customers;
import com.model.OrderItems;

public interface OrderItemsInterface {
  
	public void insert(OrderItems orditm);
		
	public void delete(OrderItems orditm);
	
	public void showMyOrders(Customers cus);
	
	public List<OrderItems> getCurrentOrder(int orderId);
	
}
