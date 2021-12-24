package com.test;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

import com.dao.CustomerDao;
import com.dao.PetDao;
import com.model.Customers;

public class CustomerMain {

	public void customer(Customers customer) throws ClassNotFoundException, SQLException, ParseException {
	
		CustomerDao cusDao = new CustomerDao();
		Scanner scan = new Scanner(System.in);
		String choice="";
		Customers updateCustomer=new Customers();
		updateCustomer.setCustomerId(customer.getCustomerId());
		
		do {
		System.out.println("1.update profile\n" + "2.update wallet\n 3.address\n" + "4.update image\n" +"5.back");
		
		int userOperation = Integer.parseInt(scan.nextLine());
		int back =0;
		switch (userOperation) {

		// update first name
		case 1:
			String firstName;
			while (true) {
				System.out.println("enter the first name");
				firstName = scan.nextLine();
				if (firstName.matches("[a-zA-Z]{3,20}")) {
					break;
				}
				if (firstName.length() <= 2) {
					System.out.println("Minimum have 3 character");
				} else if (firstName.matches(".*\\W.*") || firstName.matches(".*\\d.*")) {
					System.out.println("Accept alphabet only");
				}
			}
			updateCustomer.setFirstName(firstName);
			
		// update last name
			String lastName;
			while (true) {
				System.out.println("enter the last name");
				lastName = scan.nextLine();
				if (lastName.matches("[a-zA-Z]{3,20}")) {
					break;
				}
				if (lastName.length() <= 2) {
					System.out.println("Minimum have 3 character");
				} else if (lastName.matches(".*\\W.*") || lastName.matches(".*\\d.*")) {
					System.out.println("Accept alphabet only");
				}
			}
			updateCustomer.setLastName(lastName);
			

		// update user name
	
			String userName;
			while (true) {
				System.out.println("enter the user name");
				userName = scan.nextLine();
				if (cusDao.ValidatUsername(userName)) {
					System.out.println("user name not available");
				} else if (userName.matches("[a-zA-Z0-9]{8,20}")) {
					break;
				} else if (userName.length() <= 7) {
					System.out.println("Minimum 8 character or more");
				} else {
					System.out.println("special Character not allowed ");
				}
			}
			updateCustomer.setUserName(userName);	
		
		// update password
			String passWord;
			while (true) {
				System.out.println("enter the password");
				passWord = scan.nextLine();
				if (passWord.matches("[a-zA-Z0-9!@#$%^&*()_+]{8,20}")) {
					break;
				}
				System.out.println("Must have  8 character or more");
			}
			updateCustomer.setPassword(passWord);

		// update email
		
			String email;
			while (true) {
				System.out.println("enter the email");
				email = scan.nextLine().toLowerCase();
				if (cusDao.ValidateEmail(email)) {
					System.out.println("email not available ");
				} else if (email.matches("[a-z][a-z0-9.]*@[a-z0-9]+[.][a-z]{2,4}$")) {
					break;
				} else {
					System.out.println("email should contains @ and .");
				}
			}
			updateCustomer.setEmail(email);

		// update mobile number
			String mobileNumber;
			while (true) {

				System.out.println("enter the mobile number");
				mobileNumber = scan.nextLine();
				if (mobileNumber.matches("[6-9][0-9]{9}")) {
					break;
				} else if (mobileNumber.matches("[0-5]")) {
					System.out.println("number should be start with 6 or above");
				} else if (mobileNumber.matches(".*\\D.*")) {
					System.out.println("Accept number only");
				} else {
					System.out.println("length must be 10 character");
				}
			}
			
			updateCustomer.setNumber(Long.parseLong(mobileNumber));
			
			//input gender
		   String gender="";
			while (true) {
				System.out.println("male,female or others");
				gender = scan.nextLine().toLowerCase();
				if (gender.equals("male") || gender.equals("female") || gender.equals("others")) {
					break;
				}
				System.out.println("invalid input");
			}
			updateCustomer.setGender(gender);
			cusDao.update(updateCustomer);
			
			break;
		 case 2:
			// update bank
			String wallet;
			while (true) {

				System.out.println("enter the bank number");
				wallet = scan.nextLine();
				if (wallet.matches("[0-9]+{1,15}")) {
					break;
				} else if (wallet.matches(".*\\D.*")) {
					System.out.println("Accept number only");
				} else {
					System.out.println("length must be 8 character or more");
				}

			}
			updateCustomer.setWallet(Double.parseDouble(wallet));
			cusDao.updateWallet(updateCustomer);
			
			break;
		 case 3:
		// update address
			String address;
			while (true) {
				System.out.println("enter the Address");
				address = scan.nextLine();
				if (address.matches("[a-zA-Z0-9,-/ ]{3,50}")) {
					break;
				}
			}
			updateCustomer.setAddress(address);
		
		// update pincode
			String pincode;
			while (true) {
				System.out.println("enter the pincode");
				pincode = scan.nextLine();
				if (pincode.matches("[6][0-9]+{6}")) {
					break;
				} else {
					System.out.println("lenth should be 6");
				}
			}
			updateCustomer.setPincode(Integer.parseInt(pincode));
		
		// update city
			String city;
			while (true) {
				System.out.println("enter the city");
				city = scan.nextLine();
				if (city.matches("[a-zA-Z]{3,20}")) {
					break;
				}
				if (city.length() <= 2) {
					System.out.println("Minimum 3 character or more");
				} else if (city.matches(".*\\W.*") || city.matches(".*\\d.*")) {
					System.out.println("Accept alphabet only");
				}
			}
			updateCustomer.setCity(city);		
			cusDao.updateAddressDetails(updateCustomer);
			break;

		// update image
		case 4:
			String image;
			System.out.println("Give the image link");
			image = scan.nextLine();
			updateCustomer.setImage(image);
			cusDao.updateImage(updateCustomer);
			break;
			
		// to update bank and address and pin code 	
		case 5:
			back++;
			break;
		}
		if(back==1) {
			break;
		}
		System.out.println("do you want continue yes/no");
		choice=scan.nextLine().toLowerCase();
		}while(choice.equals("yes"));
	}
}