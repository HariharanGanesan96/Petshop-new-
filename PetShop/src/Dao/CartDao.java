package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Class.Cart;

public class CartDao {
	public void insertAnimalsDao(Cart cat) throws SQLException, ClassNotFoundException {

		ConnectionCon obj = new ConnectionCon();
		Connection con = obj.getDbConnect();
		String query = "insert into Animals_orders values(?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, cat.getCartId());
		pstmt.setInt(2, cat.getCusId());
		System.out.println(pstmt.executeUpdate() + " rows inserted");
	}

	public void updateAnimalsDao(Cart cat) throws SQLException, ClassNotFoundException {
		ConnectionCon obj = new ConnectionCon();
		Connection con = obj.getDbConnect();
		String query = "update animals_orders set status=? where Animal_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1,cat.getCusId());
		pstmt.setInt(2, cat.getCartId());
		System.out.println(pstmt.executeUpdate() + " rows updated");
	}

	public void deleteAnimalsDao(Cart cat) throws SQLException, ClassNotFoundException {
		ConnectionCon obj = new ConnectionCon();
		Connection con = obj.getDbConnect();
		String query = "delete from Animals_orders where customer_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, cat.getCartId());
		System.out.println(pstmt.executeUpdate() + " rows deleted");
	}

	public void showanimalDao() throws SQLException, ClassNotFoundException {
		ConnectionCon obj = new ConnectionCon();
		Connection con = obj.getDbConnect();
		String query = "select cart_id from cart";
		PreparedStatement pstmt = con.prepareStatement(query);
		ResultSet re = pstmt.executeQuery();
		while (re.next()) {
			System.out.println(re.getInt(1));
		}

	}

}
