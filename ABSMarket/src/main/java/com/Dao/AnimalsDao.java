package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.ABSClass.PetDetails;
public class AnimalsDao {
              
	   SimpleDateFormat formeter=new SimpleDateFormat("dd-mm-yyyy");
	   Connectionutil obj = new Connectionutil();
	   
	public void insert(PetDetails pet) throws SQLException, ClassNotFoundException {

		Connection con = obj.getDbConnect();
		String query = "INSERT into pet_details(pet_type,pet_name,pet_gender,pet_dob,pet_Qty,pet_description,\r\n"
				+ "pet_color,pet_price,pet_image,customer_id) values(?,?,?,?,?,?,?,?,?,?)";
				
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, pet.getPetType());
		pstmt.setString(2, pet.getPetName());
		pstmt.setString(3, pet.getPetGender());
		String dob=formeter.format(pet.getPetDob());
		System.out.println(dob);
		pstmt.setString (4, dob);
		pstmt.setInt(5, pet.getPetQty());
		pstmt.setString(6, pet.getDescription());
		pstmt.setString(7, pet.getPetColor());
		pstmt.setDouble(8, pet.getPetprice());
		pstmt.setString(9,pet.getPetImage());
		pstmt.setInt(10, pet.getCustomerId());
		System.out.println(pstmt.executeUpdate() + " rows inserted");
	}

	public void updateStatus(int petId,String status,int adminId) throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		String query = "update pet_details set status=? where pet_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, status);
		pstmt.setInt(2, petId);
		System.out.println(pstmt.executeUpdate() + " rows updated");
		updateadmin(adminId, petId);
	}

	public void delete(PetDetails pet) throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		String query = "delete from pet_details where pet_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, pet.getPetId());
		System.out.println(pstmt.executeUpdate() + " rows deleted");
	}

	public List<PetDetails> showAllpets() throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		List<PetDetails> petlist=new ArrayList<PetDetails>();
		String query = "select pet_id,pet_type,pet_name,pet_gender,pet_dob,pet_description,pet_color,pet_qty,pet_price,pet_image,pet_registerdate"
				+ " from pet_details where status='approved'";
		PreparedStatement pstmt = con.prepareStatement(query);
		ResultSet re = pstmt.executeQuery();
		while (re.next()) {
			PetDetails pet=new PetDetails(re.getInt(1),re.getString(2),re.getString(3),re.getString(4),
					re.getDate(5),re.getString(6),re.getString(7),re.getInt(8),re.getDouble(9),re.getString(10),
					re.getDate(11));
			petlist.add(pet);
		}	
		return petlist;	
	}
	public List<PetDetails> showAllNotapproved() throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		List<PetDetails> petlist=new ArrayList<PetDetails>();
		String query = "select pet_id,pet_type,pet_name,pet_gender,pet_dob,pet_description,"
				+ "pet_color,pet_qty,pet_price,pet_image,status,customer_id,pet_registerdate"
				+ " from pet_details where status='Not approved'";
		PreparedStatement pstmt = con.prepareStatement(query);
		ResultSet re = pstmt.executeQuery();
		while (re.next()) {
			PetDetails pet=new PetDetails(re.getInt(1),re.getString(2),re.getString(3),re.getString(4),
					re.getDate(5),re.getString(6),re.getString(7),re.getInt(8),re.getDouble(9),re.getString(10)
					,re.getString(11),re.getInt(12),re.getDate(13));
			petlist.add(pet);
		}	
		return petlist;	
	}

	public List<PetDetails> showMypetdetails(int cusId) throws ClassNotFoundException, SQLException {
		Connection con = obj.getDbConnect();
		List<PetDetails> petlist=new ArrayList<PetDetails>();
		String query = "select pet_id,pet_type,pet_name,pet_gender,pet_dob,pet_description,pet_color,pet_qty,pet_price,pet_image,status,pet_registerdate"
				+ " from pet_details where customer_id='"+cusId+"'";
		PreparedStatement pstmt = con.prepareStatement(query);
		ResultSet re = pstmt.executeQuery();
		while (re.next()) {
			PetDetails pet=new PetDetails(re.getInt(1),re.getString(2),re.getString(3),re.getString(4),
					re.getDate(5),re.getString(6),re.getString(7),re.getInt(8),re.getDouble(9),re.getString(10),
					re.getString(11),re.getDate(12));
			petlist.add(pet);
		}	
		return petlist;	
	}
	
	public void updatePetType(PetDetails pet) throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		String query = "update Pet_details set pet_type=? where pet_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, pet.getPetType());
		pstmt.setInt(2, pet.getPetId());
		System.out.println(pstmt.executeUpdate() + " rows updated");
	}
	public void updatePetName(PetDetails pet) throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		String query = "update Pet_details set pet_Name=? where pet_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, pet.getPetName());
		pstmt.setInt(2, pet.getPetId());
		System.out.println(pstmt.executeUpdate() + " rows updated");
	}
	public void updatePetGender(PetDetails pet) throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		String query = "update Pet_details set pet_Gender=? where pet_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, pet.getPetGender());
		pstmt.setInt(2, pet.getPetId());
		System.out.println(pstmt.executeUpdate() + " rows updated");
	}
	public void updatePetDob(PetDetails pet) throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		String query = "update Pet_details set pet_Dob=? where pet_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		String dob=formeter.format(pet.getPetDob());
		pstmt.setString(1, dob);
		pstmt.setInt(2, pet.getPetId());
		System.out.println(pstmt.executeUpdate() + " rows updated");
	}
	public void updatePetDescription(PetDetails pet) throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		String query = "update Pet_details set pet_description=? where pet_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);	
		pstmt.setString(1,pet.getDescription() );
		pstmt.setInt(2, pet.getPetId());
		System.out.println(pstmt.executeUpdate() + " rows updated");
	}
	public void updatePetColor(PetDetails pet) throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		String query = "update Pet_details set pet_color=? where pet_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);	
		pstmt.setString(1,pet.getPetColor() );
		pstmt.setInt(2, pet.getPetId());
		System.out.println(pstmt.executeUpdate() + " rows updated");
	}
	public void updatePetQty(PetDetails pet) throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		String query = "update Pet_details set pet_qty=? where pet_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);	
		pstmt.setInt(1,pet.getPetQty() );
		pstmt.setInt(2, pet.getPetId());
		System.out.println(pstmt.executeUpdate() + " rows updated");
	}
	public void updatePetPrice(PetDetails pet) throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		String query = "update Pet_details set pet_price=? where pet_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);	
		pstmt.setDouble(1,pet.getPetprice() );
		pstmt.setInt(2, pet.getPetId());
		System.out.println(pstmt.executeUpdate() + " rows updated");
	}
	public void updatePetImage(PetDetails pet) throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		String query = "update Pet_details set pet_Image=? where pet_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);	
		pstmt.setString(1,pet.getPetImage() );
		pstmt.setInt(2, pet.getPetId());
		System.out.println(pstmt.executeUpdate() + " rows updated");
	}
	public void updateadmin(int adminId,int petId) throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		String query = "update Pet_details set admin_id=? where pet_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);	
		pstmt.setInt(1,adminId);
		pstmt.setInt(2, petId);
		System.out.println(pstmt.executeUpdate() + " rows updated");
	}


}
