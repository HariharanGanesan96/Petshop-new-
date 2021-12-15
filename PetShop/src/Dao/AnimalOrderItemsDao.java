package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Class.Animalorders;
import Class.AnimalsOrderItems;

public class AnimalOrderItemsDao {
	public void insertAnimalsorderitemsDao(AnimalsOrderItems orditm) throws SQLException, ClassNotFoundException {

		ConnectionCon obj = new ConnectionCon();
		Connection con = obj.getDbConnect();
		String query = "insert into animal_order_items values(?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, orditm.getItemId());
		pstmt.setInt(2, orditm.getOrderId());
		pstmt.setInt(3, orditm.getAnimalId());
		pstmt.setInt(4, orditm.getQty());
		pstmt.setDouble(5, orditm.getUnitPrice());
		pstmt.setDouble(6, orditm.getTotalPrice());
		System.out.println(pstmt.executeUpdate() + " rows inserted");
	}

	public void updateAnimalsorederitemsDao(AnimalsOrderItems orditm) throws SQLException, ClassNotFoundException {
		ConnectionCon obj = new ConnectionCon();
		Connection con = obj.getDbConnect();
		String query = "update animals_orderitems set Quantity=? where item_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, orditm.getQty());
		pstmt.setInt(2, orditm.getOrderId());
		System.out.println(pstmt.executeUpdate() + " rows updated");
	}

	public void deleteAnimalsorderitemsDao(AnimalsOrderItems ord) throws SQLException, ClassNotFoundException {
		ConnectionCon obj = new ConnectionCon();
		Connection con = obj.getDbConnect();
		String query = "delete from Animals_orderitms where customer_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, ord.getOrderId());
		System.out.println(pstmt.executeUpdate() + " rows deleted");
	}

	public void showanimaloederitemsDao() throws SQLException, ClassNotFoundException {
		ConnectionCon obj = new ConnectionCon();
		Connection con = obj.getDbConnect();
		String query = "select total-rice from Animals_orderitems";
		PreparedStatement pstmt = con.prepareStatement(query);
		ResultSet re = pstmt.executeQuery();
		while (re.next()) {
			System.out.println(re.getString(1));
		}

	}
}
