package com.petinterface;

import java.util.List;

import com.model.Orders;

public interface Ordersinterface {

	public void insert(Orders ord);
	
	public void update(Orders ord);
	
	public void delete(int ordId);
	
	public void show();
	
	public List<Orders> showMyOrders(int cusId);
	
	public int orderId();
	
	
	
}
