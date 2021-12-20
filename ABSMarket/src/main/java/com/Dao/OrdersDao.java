package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ABSClass.Orders;
public class OrdersDao {
	public void insert(Orders ord) throws SQLException, ClassNotFoundException {

		Connectionutil obj = new Connectionutil();
		Connection con = obj.getDbConnect();
		String query = "insert into orders(pet_id,Customer_id,quantity,unit_price,total_price) \r\n"
				+ "values(?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, ord.getPetId());
		pstmt.setInt(2, ord.getCustomerId());
		pstmt.setInt(3, ord.getQty());
		pstmt.setDouble(4, ord.getUnitPrice());
		pstmt.setDouble(5, ord.getTotalprice());
		int i=pstmt.executeUpdate();
		System.out.println( i+ " rows inserted");
	}

	public void update(Orders ord) throws SQLException, ClassNotFoundException {
		Connectionutil obj = new Connectionutil();
		Connection con = obj.getDbConnect();
		String query = "update animals_orders set status=? where Animal_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, ord.getOrderStatus());
		pstmt.setInt(2, ord.getOrderId());
		System.out.println(pstmt.executeUpdate() + " rows updated");
	}

	public void delete(Orders ord) throws SQLException, ClassNotFoundException {
		Connectionutil obj = new Connectionutil();
		Connection con = obj.getDbConnect();
		String query = "delete from Animals_orders where customer_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, ord.getOrderId());
		System.out.println(pstmt.executeUpdate() + " rows deleted");
	}

	public void show() throws SQLException, ClassNotFoundException {
		Connectionutil obj = new Connectionutil();
		Connection con = obj.getDbConnect();
		String query = "select Animals_name from Animals";
		PreparedStatement pstmt = con.prepareStatement(query);
		ResultSet re = pstmt.executeQuery();
		while (re.next()) {
			System.out.println(re.getString(1));
		}

	}
}
