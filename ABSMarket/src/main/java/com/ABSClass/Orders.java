package com.ABSClass;

import java.sql.Date;
import java.util.Objects;

public class Orders {
	
	private int orderId;
	private int petId;
	private int customerId;
    private int qty;
    private double unitPrice;
	private double Totalprice;
	private String orderStatus;
	private Date orderDate;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getPetId() {
		return petId;
	}
	public void setPetId(int petId) {
		this.petId = petId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public double getTotalprice() {
		return Totalprice;
	}
	public void setTotalprice(double totalprice) {
		Totalprice = totalprice;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", petId=" + petId + ", customerId=" + customerId + ", qty=" + qty
				+ ", unitPrice=" + unitPrice + ", Totalprice=" + Totalprice + ", orderStatus=" + orderStatus
				+ ", orderDate=" + orderDate + "]";
	}
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Orders(int petId, int customerId, int qty, double unitPrice, double totalprice) {
		super();
		this.petId = petId;
		this.customerId = customerId;
		this.qty = qty;
		this.unitPrice = unitPrice;
		Totalprice = totalprice;
		
	}
	public Orders(int orderId, int petId, int customerId, int qty, double unitPrice, double totalprice,
			String orderStatus, Date orderDate) {
		super();
		this.orderId = orderId;
		this.petId = petId;
		this.customerId = customerId;
		this.qty = qty;
		this.unitPrice = unitPrice;
		Totalprice = totalprice;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
	}
	
}
