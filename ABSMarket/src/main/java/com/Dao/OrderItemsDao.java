package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.CartItems;
import com.model.Customers;
import com.model.OrderItems;
import com.model.Orders;
import com.petinterface.OrderItemsInterface;
import com.petinterface.Ordersinterface;



public class OrderItemsDao implements OrderItemsInterface {
	
	Connectionutil obj = new Connectionutil();
	public void insert(OrderItems orditm) {

		Connectionutil obj = new Connectionutil();
		Connection con;
		try {
			con = obj.getDbConnect();
			String query = "insert into order_items (order_id,pet_id,quantity,unit_price,total_price) values(?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, orditm.getOrderId());
			pstmt.setInt(2, orditm.getPetId());
			pstmt.setInt(3, orditm.getQuantity());
			pstmt.setDouble(4, orditm.getUnitPrice());
			pstmt.setDouble(5, orditm.getTotalPrice());
			System.out.println(pstmt.executeUpdate() + " rows inserted");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public void delete(OrderItems ord) {
		Connection con;
		try {
			con = obj.getDbConnect();
			String query = "delete from order_items where item_id=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, ord.getOrderId());
			System.out.println(pstmt.executeUpdate() + " rows deleted");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void showMyOrders(Customers cus)  {
		Connection con;
		try {
			con = obj.getDbConnect();
			String query = "select oi.item_id,oi.order_id,oi.pet_id,oi.quantity,oi.unit_price,oi.total_price,o.order_status from order_items oi inner join orders o on "
					+ "oi.order_id=o.order_id where customer_id="+cus.getCustomerId()+"";
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet re = pstmt.executeQuery();
			    System.out.format("[%10s,%10s,%10s,%10s,%10s,%10s,%15s]\n","itemId","orderId","petId","quantity","unitPrice","totalPrice","staus");
			    System.out.println("-------------------------------------------------------------------------------------------");
			while (re.next()) {
			System.out.format("[%10s,%10s,%10s,%10s,%10s,%10s,%15s]\n",re.getInt(1),re.getInt(2),re.getInt(3),re.getInt(4),re.getDouble(5),re.getDouble(6),re.getString(7));
						    
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	public List<OrderItems> getCurrentOrder(int orderId){
		// TODO Auto-generated method stub
		List<OrderItems> updateList=new ArrayList<OrderItems>();
		Connection con;
		try {
			con = obj.getDbConnect();
			String query = "select * from order_items where order_id='"+orderId+"'";
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet re = pstmt.executeQuery();
			while(re.next()) {
				OrderItems orderitems=new OrderItems(re.getInt(1),re.getInt(2),re.getInt(3),re.getInt(4),re.getDouble(5),re.getDouble(6));
				updateList.add(orderitems);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return updateList;
			}	
}
