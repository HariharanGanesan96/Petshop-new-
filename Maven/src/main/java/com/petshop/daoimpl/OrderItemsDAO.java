package com.petshop.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.petshop.model.Customers;
import com.petshop.model.OrderItems;
import com.petshop.util.ConnectionUtil;




public class OrderItemsDAO  {
	
	ConnectionUtil obj = new ConnectionUtil();
	ResultSet resultSet=null;
	OrderItems orderitems=new OrderItems();
	List<OrderItems> orderItemList=new ArrayList<OrderItems>();
	// insert order items
	public void insert(OrderItems orditm) {
		Connection con;
		try {
			con = obj.getDbConnect();
			String query = "insert into order_items (order_id,pet_id,quantity,unit_price,total_price) values(?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, orditm.getOrders().getOrderId());
			pstmt.setInt(2, orditm.getPet().getPetId());
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
			pstmt.setInt(1, ord.getOrders().getOrderId());
			System.out.println(pstmt.executeUpdate() + " rows deleted");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<OrderItems> showMyOrders(Customers cus)  {
		Connection con;
		
		System.out.println(cus.getCustomerId());
		try {
			con = obj.getDbConnect();
			String query = "select oi.order_id,oi.pet_id,p.pet_name,oi.quantity,oi.unit_price,oi.total_price,o.order_status,o.order_date,p.pet_image "
					+ "from order_items oi inner join orders o on oi.order_id=o.order_id inner join pet_details p on oi.pet_id=p.pet_id "
					+ "where o.customer_id='"+cus.getCustomerId()+"' order by o.order_id";
			PreparedStatement pstmt = con.prepareStatement(query);
			resultSet = pstmt.executeQuery();	
			while (resultSet.next()) {
				orderitems=new OrderItems();
				orderitems.getOrders().setOrderId(resultSet.getInt(1));
				orderitems.getPet().setPetId(resultSet.getInt(2));
				orderitems.getPet().setPetName(resultSet.getString(3));
				orderitems.setQuantity(resultSet.getInt(4));
				orderitems.setUnitPrice(resultSet.getDouble(5));
				orderitems.setTotalPrice(resultSet.getDouble(6));
				orderitems.getOrders().setOrderStatus(resultSet.getString(7));
				orderitems.getOrders().setOrderDate(resultSet.getDate(8));
				orderitems.getPet().setPetImage(resultSet.getString(9));
				
				orderItemList.add(orderitems);
			}		
		}
		
		 catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return orderItemList;
	}
	public List<OrderItems> getCurrentOrder(int orderId){
		// TODO Auto-generated method stub
		
		Connection con;
		try {
			con = obj.getDbConnect();
			String query = "select * from order_items where order_id='"+orderId+"'";
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet resultSet = pstmt.executeQuery();
			while(resultSet.next()) {
				orderitems=new OrderItems(resultSet.getInt(1),resultSet.getInt(2),resultSet.getInt(3),resultSet.getInt(4),resultSet.getDouble(5),resultSet.getDouble(6));
				orderItemList.add(orderitems);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderItemList;
			}	
}
