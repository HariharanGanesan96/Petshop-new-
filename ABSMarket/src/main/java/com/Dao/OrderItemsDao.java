package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ABSClass.OrderItems;



public class OrderItemsDao {
	public void insert(OrderItems orditm) throws SQLException, ClassNotFoundException {

		Connectionutil obj = new Connectionutil();
		Connection con = obj.getDbConnect();
		String query = "insert into order_items (order_id,pet_id,quantity,unit_price,total_price) values(?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, orditm.getOrderId());
		pstmt.setInt(2, orditm.getAnimalId());
		pstmt.setInt(3, orditm.getQuantity());
		pstmt.setDouble(4, orditm.getUnitPrice());
		pstmt.setDouble(5, orditm.getTotalPrice());
		System.out.println(pstmt.executeUpdate() + " rows inserted");
	}

	public void update(OrderItems orditm) throws SQLException, ClassNotFoundException {
		Connectionutil obj = new Connectionutil();
		Connection con = obj.getDbConnect();
		String query = "update animals_orderitems set Quantity=? where item_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, orditm.getQuantity());
		pstmt.setInt(2, orditm.getOrderId());
		System.out.println(pstmt.executeUpdate() + " rows updated");
	}

	public void delete(OrderItems ord) throws SQLException, ClassNotFoundException {
		Connectionutil obj = new Connectionutil();
		Connection con = obj.getDbConnect();
		String query = "delete from Animals_orderitems where item_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, ord.getOrderId());
		System.out.println(pstmt.executeUpdate() + " rows deleted");
	}

	public void show() throws SQLException, ClassNotFoundException {
		Connectionutil obj = new Connectionutil();
		Connection con = obj.getDbConnect();
		String query = "select totalPrice from Animals_orderitems";
		PreparedStatement pstmt = con.prepareStatement(query);
		ResultSet re = pstmt.executeQuery();
		while (re.next()) {
			System.out.println(re.getString(1));
		}

	}
	
}
