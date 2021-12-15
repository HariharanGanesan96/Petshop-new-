package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Class.Animalorders;
import Class.Animals;

public class AnimalOrdersDao {
  
	public void insertAnimalsOrdersDao(Animalorders ord) throws SQLException, ClassNotFoundException {

		ConnectionCon obj = new ConnectionCon();
		Connection con = obj.getDbConnect();
		String query = "insert into Animals_orders(order_id,customer_id,order_date,price) values(?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, ord.getOrderId());
		pstmt.setInt(2, ord.getCusId());
		pstmt.setString(3, ord.getDate());
		pstmt.setDouble(4, ord.getPrice());
		int i=pstmt.executeUpdate();
		System.out.println( i+ " rows inserted");
	}

	public void updateAnimalsOrdersDao(Animalorders ord) throws SQLException, ClassNotFoundException {
		ConnectionCon obj = new ConnectionCon();
		Connection con = obj.getDbConnect();
		String query = "update animals_orders set status=? where Animal_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, ord.getStatus());
		pstmt.setInt(2, ord.getOrderId());
		System.out.println(pstmt.executeUpdate() + " rows updated");
	}

	public void deleteAnimalsordersDao(Animalorders ord) throws SQLException, ClassNotFoundException {
		ConnectionCon obj = new ConnectionCon();
		Connection con = obj.getDbConnect();
		String query = "delete from Animals_orders where customer_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, ord.getOrderId());
		System.out.println(pstmt.executeUpdate() + " rows deleted");
	}

	public void showanimalordersDao() throws SQLException, ClassNotFoundException {
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
