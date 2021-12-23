package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.model.PetDetails;
public class PetDao {
              
	   SimpleDateFormat formeter=new SimpleDateFormat("dd-mm-yyyy");
	   Connectionutil obj = new Connectionutil();
	 // insert operation from user
	public void insert(PetDetails pet) {

		Connection con;
		try {
			con = obj.getDbConnect();
			String query = "INSERT into pet_details(pet_type,pet_name,pet_gender,pet_dob,pet_Qty,pet_description,\r\n"
					+ "pet_color,pet_price,pet_image,customer_id,available_qty) values(?,?,?,?,?,?,?,?,?,?,?)";
					
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
			pstmt.setInt(11, pet.getAvilableQty());
			System.out.println(pstmt.executeUpdate() + " rows inserted");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
     
	// To update pet Status
	public void updateStatus(int petId,String status,int adminId) {
		Connection con;
		try {
			con = obj.getDbConnect();
			String query = "update pet_details set status=?,admin_id=? where pet_id=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, status);
			pstmt.setInt(2, adminId);
			pstmt.setInt(3, petId);
			System.out.println(pstmt.executeUpdate()+ " rows updated");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
    
	// To delete particular pet_details
	public void delete(PetDetails pet) {
		Connection con;
		try {
			con = obj.getDbConnect();
			String query = "delete from pet_details where pet_id=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, pet.getPetId());
			System.out.println(pstmt.executeUpdate() + " rows deleted");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	// to show all the approved pet details
	public void showAllpets()  {
		Connection con;
		try {
			con = obj.getDbConnect();
			String query = "select pet_id,pet_type,pet_name,pet_gender,pet_dob,pet_description,pet_color,pet_qty,pet_price,pet_image,pet_registerdate,available_qty"
					+ " from pet_details where status='approved' and available_qty >0";
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet re = pstmt.executeQuery();
			while (re.next()) {			
			System.out.format("%5s,%15s,%15s,%15s,%15s,%15s,%50s,%15s,%15s,%15s,%15s,%15s\n",
					re.getInt(1),re.getString(2),re.getString(3),re.getString(4),re.getDate(5),
					re.getString(6),re.getString(7),re.getInt(8),re.getDouble(9),re.getString(10),
					re.getDate(11),re.getInt(12));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}	
	}

	// to get particular pet data
	public PetDetails showPet(int petId)  {
		Connection con;
		PetDetails pet=null;
		try {
			con = obj.getDbConnect();
			String query = "select pet_id,pet_type,pet_name,pet_gender,pet_dob,pet_description,pet_color,pet_qty,pet_price,pet_image,pet_registerdate,available_qty"
					+ " from pet_details where pet_id=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1,petId );
			ResultSet re = pstmt.executeQuery();
			while (re.next()) {
				 pet=new PetDetails(re.getInt(1),re.getString(2),re.getString(3),re.getString(4),
						re.getDate(5),re.getString(6),re.getString(7),re.getInt(8),re.getDouble(9),re.getString(10),
						re.getDate(11),re.getInt(12));
			}	
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pet;	
	}
	
	// pet list to show admin
	public void showNotApprovedPetList() {
		Connection con;
		try {
			con = obj.getDbConnect();
			String query = "select pet_id,pet_type,pet_name,pet_gender,pet_dob,pet_description,"
					+ "pet_color,pet_qty,pet_price,pet_image,status,customer_id,pet_registerdate,available_qty"
					+ " from pet_details where status='Not approved'";
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet re = pstmt.executeQuery();
			while (re.next()) {
				System.out.format("%5s,%15s,%15s,%15s,%15s,%15s,%15s,%15s,%15s,%15s,%15s,%15s,%15s,%15s\n",
						re.getInt(1),re.getString(2),re.getString(3),re.getString(4),re.getDate(5),
						re.getString(6),re.getString(7),re.getInt(8),re.getDouble(9),re.getString(10),
						re.getString(11),re.getInt(12),re.getDate(13),re.getInt(14));
				
			}	
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	// My pet details for customer
	public void showMypetdetails(int cusId){
		Connection con;
		try {
			con = obj.getDbConnect();
			String query = "select pet_id,pet_type,pet_name,pet_gender,pet_dob,pet_description,pet_color,pet_qty,pet_price,pet_image,status,pet_registerdate,available_Qty"
					+ " from pet_details where customer_id='"+cusId+"'";
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet re = pstmt.executeQuery();
			while (re.next()) {
						
			  System.out.format("%5s,%8s,%15s,%6s,%10s,%100s,%10s,%5s,%5s,%100s,%15s,%10s,%5s\n",
					    re.getInt(1),re.getString(2),re.getString(3),re.getString(4),re.getDate(5),
					    re.getString(6),re.getString(7),re.getInt(8),re.getDouble(9),re.getString(10),
						re.getString(11),re.getDate(12),re.getInt(13));
			}	
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	
	
	// To edit the Pet Type
	public void updatePetType(PetDetails pet) throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		String query = "update Pet_details set pet_type=? where pet_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, pet.getPetType());
		pstmt.setInt(2, pet.getPetId());
		System.out.println(pstmt.executeUpdate() + " rows updated");
	}
	// To update pet Name
	public void updatePetName(PetDetails pet) throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		String query = "update Pet_details set pet_Name=? where pet_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, pet.getPetName());
		pstmt.setInt(2, pet.getPetId());
		System.out.println(pstmt.executeUpdate() + " rows updated");
	}
	//To update pet gender
	public void updatePetGender(PetDetails pet) throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		String query = "update Pet_details set pet_Gender=? where pet_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, pet.getPetGender());
		pstmt.setInt(2, pet.getPetId());
		System.out.println(pstmt.executeUpdate() + " rows updated");
	}
	//To update pet Dob
	public void updatePetDob(PetDetails pet) throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		String query = "update Pet_details set pet_Dob=? where pet_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		String dob=formeter.format(pet.getPetDob());
		pstmt.setString(1, dob);
		pstmt.setInt(2, pet.getPetId());
		System.out.println(pstmt.executeUpdate() + " rows updated");
	}
	
	// To update pet Description
	public void updatePetDescription(PetDetails pet) throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		String query = "update Pet_details set pet_description=? where pet_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);	
		pstmt.setString(1,pet.getDescription() );
		pstmt.setInt(2, pet.getPetId());
		System.out.println(pstmt.executeUpdate() + " rows updated");
	}
	
	// To update Pet Color
	public void updatePetColor(PetDetails pet) throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		String query = "update Pet_details set pet_color=? where pet_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);	
		pstmt.setString(1,pet.getPetColor() );
		pstmt.setInt(2, pet.getPetId());
		System.out.println(pstmt.executeUpdate() + " rows updated");
	}
	
	// To update Pet Qty
	public void updatePetQty(PetDetails pet) throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		String query = "update Pet_details set pet_qty=? where pet_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);	
		pstmt.setInt(1,pet.getPetQty() );
		pstmt.setInt(2, pet.getPetId());
		System.out.println(pstmt.executeUpdate() + " rows updated");
	}
	
	// To update Available quantity
	public void updatePetAviQty(PetDetails pet) throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		String query = "update Pet_details set available_qty=? where pet_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);	
		pstmt.setInt(1,pet.getAvilableQty() );
		pstmt.setInt(2, pet.getPetId());
		System.out.println(pstmt.executeUpdate() + " rows updated");
	}
	
    // To update the pet price
	public void updatePetPrice(PetDetails pet) throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		String query = "update Pet_details set pet_price=? where pet_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);	
		pstmt.setDouble(1,pet.getPetprice() );
		pstmt.setInt(2, pet.getPetId());
		System.out.println(pstmt.executeUpdate() + " rows updated");
	}
	
	// To update Pet Image
	public void updatePetImage(PetDetails pet) throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		String query = "update Pet_details set pet_Image=? where pet_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);	
		pstmt.setString(1,pet.getPetImage() );
		pstmt.setInt(2, pet.getPetId());
		System.out.println(pstmt.executeUpdate() + " rows updated");
	}
	
	// To update admin id
	public void updateadmin(int adminId,int petId) throws SQLException, ClassNotFoundException {
		Connection con = obj.getDbConnect();
		String query = "update Pet_details set admin_id=? where pet_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);	
		pstmt.setInt(1,adminId);
		pstmt.setInt(2, petId);
		System.out.println(pstmt.executeUpdate() + " rows updated");
	}


}
