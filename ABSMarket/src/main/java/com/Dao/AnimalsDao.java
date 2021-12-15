package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.ABSClass.Animals;
public class AnimalsDao {
               
	public void insert(Animals anim) throws SQLException, ClassNotFoundException {

		Connectionutil obj = new Connectionutil();
		Connection con = obj.getDbConnect();
		String query = "INSERT into Animals(animal_id,animal_type,animal_name,animal_gender,animal_dob,"
				+ "animal_description,\r\n"
				+ "animal_color,animal_price,customer_id) values(?,?,?,?,?,?,?,?,?);";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, anim.getAnimalId());
		pstmt.setString(2, anim.getAnimalType());
		pstmt.setString(3, anim.getAnimalName());
		pstmt.setString(4, anim.getAnimalGender());
		pstmt.setDate(5, anim.getDobDate());
		pstmt.setString(6, anim.getDescription());
		pstmt.setString(7, anim.getAnimalColor());
		pstmt.setDouble(8, anim.getPrice());
		pstmt.setInt(9, anim.getCustomerId());
		System.out.println(pstmt.executeUpdate() + " rows inserted");
	}

	public void update(Animals anim) throws SQLException, ClassNotFoundException {
		Connectionutil obj = new Connectionutil();
		Connection con = obj.getDbConnect();
		String query = "update animals set status=? where Animal_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, anim.getStatus());
		pstmt.setInt(2, anim.getAnimalId());
		System.out.println(pstmt.executeUpdate() + " rows updated");
	}

	public void delete(Animals anim) throws SQLException, ClassNotFoundException {
		Connectionutil obj = new Connectionutil();
		Connection con = obj.getDbConnect();
		String query = "delete from Animals where animal_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, anim.getAnimalId());
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
