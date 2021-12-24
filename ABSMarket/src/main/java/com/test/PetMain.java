package com.test;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.dao.CartItemsDao;
import com.dao.OrderItemsDao;
import com.dao.OrdersDao;
import com.dao.PetDao;
import com.model.CartItems;
import com.model.Customers;
import com.model.OrderItems;
import com.model.Orders;
import com.model.PetDetails;

public class PetMain {

	public void petDetils(Customers customer) throws ClassNotFoundException, SQLException, ParseException {
		
		Scanner scan = new Scanner(System.in);
		PetDao petDao = new PetDao();
	    int back=0;
	    String choice=null;
	    do {
		// for information purpose 
		System.out.println("select you option");
		System.out.println(
				"1.Register new pet\n"
				+ "2.update my pet detilas\n"
				+ "3.back");
		int PetOperation = Integer.parseInt(scan.nextLine());
    
		switch (PetOperation) {
		
		// animal register
		case 1:
		
			// pet type
			String petType;
			while (true) {
				System.out.println("enter the pet type");
				petType = scan.nextLine();
				if (petType.matches("[a-zA-Z]{3,20}")) {
					break;
				}
				if (petType.length() <= 2) {
					System.out.println("Minimum 3 character or more");
				} else if (petType.matches(".*\\W.*") || petType.matches(".*\\d.*")) {
					System.out.println("Alphabet only");
				}
			}

			// pet name
			String petName;
			while (true) {
				System.out.println("enter the pet name");
				petName = scan.nextLine();
				if (petName.matches("[a-zA-Z ]{3,20}")) {
					break;
				}
				if (petName.length() <= 2) {
					System.out.println("Minimum 3 character or more");
				} else if (petName.matches(".*\\W.*") || petName.matches(".*\\d.*")) {
					System.out.println("Alphabet only");
				}

			}

			// pet gender
			String petGender;
			while (true) {
				System.out.println("male or female");
				petGender = scan.nextLine().toLowerCase();
				if (petGender.equals("male") || petGender.equals("female")) {
					break;
				}
				System.out.println("invalid input");
			}

			// pet Dob
			String petDob;
			SimpleDateFormat dateFormet = new SimpleDateFormat("dd-mm-yyyy");
			System.out.println("enter the Pet dob dd-mm-yyyy");
			petDob = scan.nextLine();
			Date date = dateFormet.parse(petDob);

			// input Description
			String Description;
			while (true) {
				System.out.println("enter the Description");
				Description = scan.nextLine();
				if (Description.length() <= 30) {
					System.out.println("minmum 30 character");
				}
				else {
					break;
				}
			}
				// color
				String petColor;
				while (true) {
					System.out.println("enter the color");
					petColor = scan.nextLine();
					if (petColor.matches("[a-zA-z]+")) {
						break;
					} else {
						System.out.println("invalid color name");
					}
				}

				// pet Qty
				String petQty;
				while(true) {
				System.out.println("enter the quantity");
				petQty = scan.nextLine();
				if(petQty.matches(".*\\W.*") || petQty.matches(".*\\D.*")) {
					System.out.println("invalid number");
				}
				else {
					break;
				}
				}
				
				// pet price
				String petPrice;
				while(true) {
				System.out.println("enter the pet price");
				petPrice = scan.nextLine();
				if(petPrice.matches(".*\\W.*") || petPrice.matches(".*\\D.*")) {
					System.out.println("invalid number");
				}
				else {
					break;
				}
				}

				// pet Image
				String petImage;
				System.out.println("enter link address of image");
				petImage = scan.nextLine();

				// create object for insert values
				PetDetails pet = new PetDetails(petType, petName, petGender, date, Integer.parseInt(petQty),
						Description, petColor, Double.parseDouble(petPrice), petImage, customer.getCustomerId(),
						Integer.parseInt(petQty));

				petDao.insert(pet);
		
				break;
			
		
		// to my pet details and update
		case 2:
			
			petDao.showMypetdetails(customer.getCustomerId());	
			// used to store the values
			pet = new PetDetails();
			
			// asking id for updating 
			System.out.println("enter pet id value need to update");
			int update = Integer.parseInt(scan.nextLine());
			pet.setPetId(update);
			pet.setCustomerId(customer.getCustomerId());
			
			// asking which value need to update
			
			System.out.println("enter the update operation");
			System.out.println("1.Update petDetails\n2.delete");

			int updateOperation = Integer.parseInt(scan.nextLine());

			switch (updateOperation) {

			// update pet type
			case 1:
				while (true) {
					System.out.println("enter the pet type");
					petType = scan.nextLine();
					if (petType.matches("[a-zA-Z]{3,20}")) {
						break;
					}
					if (petType.length() <= 2) {
						System.out.println("Must have minimum 3 character");
					} else if (petType.matches(".*\\W.*") || petType.matches(".*\\d.*")) {
						System.out.println("Alphabet only");
					}
				}
				pet.setPetType(petType);

			// update petName
				while (true) {
					System.out.println("enter the pet Name");
					petName = scan.nextLine();
					if (petName.matches("[a-zA-Z]{3,20}")) {
						break;
					}
					if (petName.length() <= 2) {
						System.out.println("Must have minimum 3 character");
					} else if (petName.matches(".*\\W.*") || petName.matches(".*\\d.*")) {
						System.out.println("Alphabet only");
					}
				}
				pet.setPetName(petName);

			// update Pet Gender
				while (true) {
					System.out.println("enter the pet type");
					petGender = scan.nextLine();
					if (petGender.matches("[a-zA-Z]{3,20}")) {
						break;
					}
					if (petGender.length() <= 2) {
						System.out.println("Must have minimum 3 character");
					} else if (petGender.matches(".*\\W.*") || petGender.matches(".*\\d.*")) {
						System.out.println("Alphabet only");
					}
				}
				pet.setPetGender(petGender);
				
			// update pet DOB
				
				dateFormet = new SimpleDateFormat("dd-mm-yyyy");
				System.out.println("enter the Pet dob dd-mm-yyyy");
				petDob = scan.nextLine();
				date = dateFormet.parse(petDob);
				pet.setPetDob(date);
							
			// pet qty
		
				while(true) {
				System.out.println("enter the quantity");
				petQty = scan.nextLine();
				if(petQty.matches(".*\\W.*") || petQty.matches(".*\\D.*")) {
					System.out.println("invalid number");
				}
				else {
					break;
				}
				}
				pet.setPetQty(Integer.parseInt(petQty));
				            
			// pet price
			
				while(true) {
					System.out.println("enter the pet price");
					 petPrice = scan.nextLine();
					if(petPrice.matches(".*\\W.*") || petPrice.matches(".*\\D.*")) {
						System.out.println("invalid number");
					}
					else {
						break;
					}
					}
				pet.setPetprice(Double.parseDouble(petPrice));
				
			
			
			// update description
				while (true) {
					System.out.println("enter the Description");
					Description = scan.nextLine();
					if (Description.length() <= 30) {
						System.out.println("minmum 30 character");
					} else {
						break;
					}

				}
				pet.setDescription(Description);
				
			
			// update color
		
				while (true) {
					System.out.println("enter the color");
					petColor = scan.nextLine();
					if (petColor.matches("[a-zA-z]+")) {
						break;
					} else {
						System.out.println("invalid color name");
					}
				}
				pet.setPetColor(petColor);
			
				
			// update Image
			
				System.out.println("enter link address of image");
				petImage = scan.nextLine();
				pet.setPetImage(petImage);
				
				petDao.update(pet);
				break;

			// delete pet
			case 2:
				System.out.println("enter pet id need to delete");
				petDao.delete(pet);
			}
		break;
		case 3:
			back++;
			break;
		
		}
		if(back==1) {
			break;
		}
		System.out.println("do you want continue yes/no");
		choice=scan.nextLine();
	    }while(choice.equals("yes"));

	}

}
