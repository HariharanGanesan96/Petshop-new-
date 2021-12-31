package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.daointerface.Ordersinterface;
import com.model.Orders;
public class OrdersDao implements Ordersinterface{
	
	// To get connection from connection util
	Connectionutil obj = new Connectionutil();
	
	//To insert the values on orders table
	public void insert(Orders ord) {
		Connection con;
		try {
			con = obj.getDbConnect();
			String query = "insert into orders(Customer_id,total_price) \r\n"
					+ "values(?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, ord.getCustomerId());
			pstmt.setDouble(2, ord.getTotalprice());
			int i=pstmt.executeUpdate();
			System.out.println( i+ " rows inserted");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
        
	// To delete particular order from order table
	public void updateStatus(int ordId)  {
		Connection con;
		try {
			con = obj.getDbConnect();
			String query = "update orders set order_status='cancelled' where order_id=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, orderId());
			System.out.println(pstmt.executeUpdate() + " rows deleted");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
    
	// To show the all the orders 
	
	public List<Orders> showMyOrders(int cusId) {
		Connection con;
		try {
			con = obj.getDbConnect();
			String query = "select * from orders o inner join order_items oi"
					+ "on o.order_id=oi.order_id where customer_id='"+cusId+"'";
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet re = pstmt.executeQuery();
			while (re.next()) {
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;

	}
    // To get last orderId value to insert
	public int orderId() {
		Connection con;
		int orderid=0;
		try {
			con = obj.getDbConnect();
			String query = "select max(order_id) from orders";
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet re = pstmt.executeQuery();
			while (re.next()) {
				System.out.println(re.getString(1));
				orderid=re.getInt(1);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
       return orderid;
	}

	
}
