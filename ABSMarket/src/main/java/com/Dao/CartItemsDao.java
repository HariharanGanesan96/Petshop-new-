package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ABSClass.CartItems;



public class CartItemsDao {
	
	public void insert(CartItems cartit) {

		Connectionutil obj = new Connectionutil();
		Connection con;
	
		try {
			con = obj.getDbConnect();
			String query = "insert into Cart_items values(?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, cartit.getItemId());
			pstmt.setInt(2, cartit.getAnimalId());
			pstmt.setInt(3, cartit.getCartId());
			pstmt.setInt(4, cartit.getQuantity());
			pstmt.setDouble(5, cartit.getUnitPrice());
			pstmt.setDouble(6, cartit.getTotalPrice());
			System.out.println(pstmt.executeUpdate() + " rows inserted");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	public void update(CartItems cartit) throws SQLException, ClassNotFoundException {
		Connectionutil obj = new Connectionutil();
		Connection con = obj.getDbConnect();
		String query = "update Cart_items set Quantity=? where item_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, cartit.getQuantity());
		pstmt.setInt(2, cartit.getItemId());
		System.out.println(pstmt.executeUpdate() + " rows updated");
	}

	public void delete(CartItems cartit) throws SQLException, ClassNotFoundException {
		Connectionutil obj = new Connectionutil();
		Connection con = obj.getDbConnect();
		String query = "delete from cartitems where item_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, cartit.getItemId());
		System.out.println(pstmt.executeUpdate() + " rows deleted");
	}

	
	public void show() throws SQLException, ClassNotFoundException {
		Connectionutil obj = new Connectionutil();
		Connection con = obj.getDbConnect();
		String query = "select totalPrice from cart_items";
		PreparedStatement pstmt = con.prepareStatement(query);
		ResultSet re = pstmt.executeQuery();
		while (re.next()) {
			System.out.println(re.getInt(1));
		}

	}
}
