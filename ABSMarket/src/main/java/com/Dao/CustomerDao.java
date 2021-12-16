package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.ABSClass.Customers;

public class CustomerDao {

	
	Connectionutil obj = new Connectionutil();
	
	public void insert(Customers cus) throws ClassNotFoundException, SQLException {
		Connection con = obj.getDbConnect();
		String query = "insert into Animals_Customers(customer_firstname,customer_lastname,"
				+ "customer_username,customer_password,customer_email,customer_mobilenumber,customer_gender)\r\n"
				+ "values (?,?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, cus.getFirstName());
		pstmt.setString(2, cus.getLastName());
		pstmt.setString(3, cus.getUserName());
		pstmt.setString(4, cus.getPassword());
		pstmt.setString(5, cus.getEmail());
		pstmt.setLong(6, cus.getNumber());
		pstmt.setString(7, cus.getGender());
		int i = pstmt.executeUpdate();
		System.out.println(i+" row updated");
	}

	public void update(Customers cus) throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		String query = "update animals_Customers set customer_bank=?,customer_address=?,customer_pincode=? where customer_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setLong(1, cus.getBank());
		pstmt.setString(2,cus.getAddress());
		pstmt.setInt(3, cus.getPincode());
		pstmt.setInt(4, cus.getCustomerId());
		System.out.println(pstmt.executeUpdate() + " rows updated");
	}
	
    public void updateBank(Customers cus) throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		String query = "update animals_Customers set customer_bank=? where customer_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setLong(1, cus.getBank());
		pstmt.setInt(2, cus.getCustomerId());
		System.out.println(pstmt.executeUpdate() + " rows updated");
	}
	
    public void updateAddress(Customers cus) throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		String query = "update animals_Customers set customer_address=?,customer_pincode=? where customer_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1,cus.getAddress());
		pstmt.setInt(2, cus.getPincode());
		pstmt.setInt(3, cus.getCustomerId());
		System.out.println(pstmt.executeUpdate() + " rows updated");
	}

	public void delete(Customers cus) throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		String query = "delete from Animals_Customers where customer_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, cus.getCustomerId());
		System.out.println(pstmt.executeUpdate() + " rows deleted");
	}
	
	public String cusValidation(Customers cus) throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		String query = "select customer_firstname from animals_customers where customer_username=? and customer_password=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, cus.getUserName());
		pstmt.setString(2, cus.getPassword());
		ResultSet re = pstmt.executeQuery();		
		if (re.next()) {
			cus.setFirstName(re.getString(1));
			return "1"+re.getString(1);
		}
		else if(true){
		 query = "select Admin_username from animals_adminuser where admin_username=? and admin_password=?";
		 PreparedStatement pstmt1 = con.prepareStatement(query);
			pstmt1.setString(1, cus.getUserName());
			pstmt1.setString(2, cus.getPassword());
			ResultSet re1 = pstmt1.executeQuery();
			if (re1.next()) {
				cus.setFirstName(re1.getString(1));
				return "2"+re1.getString(1);
			}
		}
           return null;
	}
	
	public boolean ValidatUsername(String cus) throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		boolean flag=false;
		String query = "select * from animals_customers where customer_username=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, cus);
		ResultSet re = pstmt.executeQuery();
		if (re.next()) {
			flag= true;
		}
		else if(true){
			 query = "select * from animals_adminuser where admin_username=?";
			 pstmt = con.prepareStatement(query);
				pstmt.setString(1, cus);
				ResultSet re1 = pstmt.executeQuery();
				if (re1.next()) {
					flag= true;
				}
     	}	
		return flag;
	}
	
    public boolean ValidateEmail(String cus) throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		boolean flag=false;
		String query = "select * from animals_customers where customer_email=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, cus);
		ResultSet re = pstmt.executeQuery();
		if (re.next()) {
			flag=true;
		}
		else if(true){
			 query = "select e.employee_email from animals_adminuser a inner join animals_employees e on"
			 		+ " e.employee_id=a.admin_employeeid where e.employee_email=?";
			 pstmt = con.prepareStatement(query);
				pstmt.setString(1, cus);
				ResultSet re1 = pstmt.executeQuery();
				if (re1.next()) {
					flag=true;
				}
     	}	
		return flag;
	}
	
    public void showAnimalCustomerDao() throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		String query = "select * from Animals_customers";
		PreparedStatement pstmt = con.prepareStatement(query);
		ResultSet re = pstmt.executeQuery();
		while (re.next()) {
//		Customers user=new Customers(re.getInt(1),re.getString(2),re.getString(3),re.getString(4),re.getString(5),
//				                     re.getString(6),re.getInt(7),re.getString(8),re.getDate(9),re.getString(10),re.getInt(11),re.getString(12),re.getString(13));
		}

	}

}
