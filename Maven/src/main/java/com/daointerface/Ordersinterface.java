package com.daointerface;

import java.util.List;

import com.model.Orders;

public interface Ordersinterface {

	public void insert(Orders ord);
		
	public void updateStatus(int ordId);
	
	public List<Orders> showMyOrders(int cusId);
	
	public int orderId();
	
	
	
}
