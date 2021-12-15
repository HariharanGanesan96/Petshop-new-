package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Class.AnimalsCustomers;

public class AnimalCustomerDao {

	public void insertAnimalsCustomerDao(AnimalsCustomers cus) throws SQLException, ClassNotFoundException {

		ConnectionCon obj = new ConnectionCon();
		Connection con = obj.getDbConnect();
		String query = "insert into Animals_customers (Customer_id,Customer_first_name,customer_last_name,customer_username,"
				+ "    customer_password,customer_email,customer_mobilenumber,customer_bank,role) values (?,?,?,?,?,?,?,?,?)";
        
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, cus.getCustomerId());
		pstmt.setString(2, cus.getFirstName());
		pstmt.setString(3, cus.getLastName());
		pstmt.setString(4, cus.getUserName());
		pstmt.setString(5, cus.getPassword());
		pstmt.setString(6, cus.getEmail());
		pstmt.setLong(7, cus.getNumber());
		pstmt.setLong(8, cus.getBank());
		pstmt.setString(9, cus.getRole());
		int i=pstmt.executeUpdate();
		System.out.println(i);
		
	}

	public void updateAnimalCustomerDao(AnimalsCustomers cus) throws SQLException, ClassNotFoundException {
		ConnectionCon obj = new ConnectionCon();
		Connection con = obj.getDbConnect();
		String query = "update animals_Customers set customer_bank=? where customer_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setLong(1, cus.getBank());
		pstmt.setInt(2, cus.getCustomerId());
		System.out.println(pstmt.executeUpdate() + " rows updated");
	}

	public void deleteAnimalCustomerDao(AnimalsCustomers cus) throws SQLException, ClassNotFoundException {
		ConnectionCon obj = new ConnectionCon();
		Connection con = obj.getDbConnect();
		String query = "delete from Animals_Customers where customer_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, cus.getCustomerId());
		System.out.println(pstmt.executeUpdate() + " rows deleted");
	}

	public void showAnimalCustomerDao() throws SQLException, ClassNotFoundException {
		ConnectionCon obj = new ConnectionCon();
		Connection con = obj.getDbConnect();
		String query="select Customer_firs_tname from Animals_customer";
		PreparedStatement pstmt=con.prepareStatement(query);
		ResultSet re=pstmt.executeQuery();
		while(re.next()) {
			System.out.println(re.getString(1));
		}

}
}