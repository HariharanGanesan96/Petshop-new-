package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Class.Animals;

public class AnimalsDao {

	public void insertAnimalsDao(Animals anim) throws SQLException, ClassNotFoundException {

		ConnectionCon obj = new ConnectionCon();
		Connection con = obj.getDbConnect();
		String query = "insert into animals(animal_id,animal_type,animal_name,animal_gender,animal_dob,animal_Description,\r\n"
				+ "                     animal_color,animal_price,customer_id) values (?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, anim.getAnimalId());
		pstmt.setString(2, anim.getType());
		pstmt.setString(3, anim.getName());
		pstmt.setString(4, anim.getGender());
		pstmt.setString(5, anim.getDob());
		pstmt.setString(6, anim.getDsc());
		pstmt.setString(7, anim.getColor());
		pstmt.setDouble(8, anim.getPrice());
		pstmt.setInt(9, anim.getCusId());
		System.out.println(pstmt.executeUpdate() + " rows inserted");
	}

	public void updateAnimalsDao(Animals anim) throws SQLException, ClassNotFoundException {
		ConnectionCon obj = new ConnectionCon();
		Connection con = obj.getDbConnect();
		String query = "update animals set status=? where Animal_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, anim.getStatus());
		pstmt.setInt(2, anim.getAnimalId());
		System.out.println(pstmt.executeUpdate() + " rows updated");
	}

	public void deleteAnimalsDao(Animals anim) throws SQLException, ClassNotFoundException {
		ConnectionCon obj = new ConnectionCon();
		Connection con = obj.getDbConnect();
		String query = "delete from Animals where animal_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, anim.getAnimalId());
		System.out.println(pstmt.executeUpdate() + " rows deleted");
	}

	public void showAnimalDao() throws SQLException, ClassNotFoundException {
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
