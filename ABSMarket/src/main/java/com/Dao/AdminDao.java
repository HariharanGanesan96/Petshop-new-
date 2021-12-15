package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ABSClass.Admin;



public class AdminDao {
	
	public void insert(Admin adm) throws SQLException, ClassNotFoundException {

	Connectionutil obj = new Connectionutil();
	Connection con = obj.getDbConnect();
	String query = "insert into animals_Adminuser values(?,?,?,?,?);";
	PreparedStatement pstmt = con.prepareStatement(query);
	pstmt.setInt(1, adm.getAdminId());
	pstmt.setString(2, adm.getUserName());
	pstmt.setString(3, adm.getPassword());
	pstmt.setInt(4, adm.getEmployeeId());
	pstmt.setDate(5, adm.getRegisterDate());
	
	System.out.println(pstmt.executeUpdate() + " rows inserted");
}

public void update(Admin adm) throws SQLException, ClassNotFoundException {
	Connectionutil obj = new Connectionutil();
	Connection con = obj.getDbConnect();
	String query = "update animals_Adminuser set admin_password=? where admin_id=? ";
	PreparedStatement pstmt = con.prepareStatement(query);
	pstmt.setString(1, adm.getPassword());
	pstmt.setInt(2, adm.getAdminId());
	System.out.println(pstmt.executeUpdate() + " rows updated");
}

public void delete(Admin anim) throws SQLException, ClassNotFoundException {
	Connectionutil obj = new Connectionutil();
	Connection con = obj.getDbConnect();
	String query = "delete from animals_Adminuser where admin_id=?";
	PreparedStatement pstmt = con.prepareStatement(query);
	pstmt.setInt(1, anim.getAdminId());
	System.out.println(pstmt.executeUpdate() + " rows deleted");
}

public void show() throws SQLException, ClassNotFoundException {
	Connectionutil obj = new Connectionutil();
	Connection con = obj.getDbConnect();
	String query = "select Admin_username from animals_Adminuser";
	PreparedStatement pstmt = con.prepareStatement(query);
	ResultSet re = pstmt.executeQuery();
	while (re.next()) {
		System.out.println(re.getString(1));
	}

}

}
