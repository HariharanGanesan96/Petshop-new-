package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Class.Animalorders;
import Class.CartItems;

public class CartItemsDao {
	public void insertAnimalsDao(CartItems cartim) throws SQLException, ClassNotFoundException {

		ConnectionCon obj = new ConnectionCon();
		Connection con = obj.getDbConnect();
		String query = "insert into Animals_orders values(?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, cartim.getItemId());
		pstmt.setInt(2, cartim.getAnimalId());
		pstmt.setInt(3, cartim.getCusId());
		pstmt.setInt(4, cartim.getQty());
		pstmt.setDouble(5, cartim.getUnitPrice());
		pstmt.setDouble(6, cartim.getTotalPrice());
		
		System.out.println(pstmt.executeUpdate() + " rows inserted");
	}

	public void updateAnimalsDao(CartItems cartim) throws SQLException, ClassNotFoundException {
		ConnectionCon obj = new ConnectionCon();
		Connection con = obj.getDbConnect();
		String query = "update cartitems set quantity=? where item_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, cartim.getQty());
		pstmt.setInt(2, cartim.getItemId());
		System.out.println(pstmt.executeUpdate() + " rows updated");
	}

	public void deleteAnimalsDao(CartItems cartim) throws SQLException, ClassNotFoundException {
		ConnectionCon obj = new ConnectionCon();
		Connection con = obj.getDbConnect();
		String query = "delete from Animals_orders where customer_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, cartim.getItemId());
		System.out.println(pstmt.executeUpdate() + " rows deleted");
	}

	public void showanimalDao() throws SQLException, ClassNotFoundException {
		ConnectionCon obj = new ConnectionCon();
		Connection con = obj.getDbConnect();
		String query = "select Animals_name from Animals";
		PreparedStatement pstmt = con.prepareStatement(query);
		ResultSet re = pstmt.executeQuery();
		while (re.next()) {
			System.out.println(re.getString(1));
		}

	}

}
