package com.test;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.dao.AdminDao;
import com.dao.CustomerDao;
import com.dao.PetDao;
import com.exception.QtyNotAvalilable;
import com.model.Admin;
import com.model.Customers;
import com.model.PetDetails;

public class Register {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException, QtyNotAvalilable {

		Scanner scan = new Scanner(System.in);
		CustomerDao cusDao = new CustomerDao();
		AdminDao adminDao = new AdminDao();
		Customers customer = new Customers();
		// Asking for operation
		System.out.println("Enter the operation");
		System.out.println("1.register\n2.login validation\n");
		
		int operation = Integer.parseInt(scan.nextLine());

		switch (operation) {
		// Register operation
		case 1:
			String[] input = new String[7];

			// Input first name
			while (true) {
				System.out.println("enter the first name");
				input[0] = scan.nextLine();
				if (input[0].matches("[a-zA-Z]{3,20}")) {
					break;
				}
				if (input[0].length() <= 2) {
					System.out.println("Must have minimum 3 character");
				} else if (input[0].matches(".*\\W.*") || input[0].matches(".*\\d.*")) {
					System.out.println("Alphabet only");
				}
			}

			// input last name
			while (true) {
				System.out.println("enter the last name");
				input[1] = scan.nextLine();
				if (input[1].matches("[a-zA-Z]{3,20}")) {
					break;
				}
				if (input[1].length() <= 2) {
					System.out.println("Must have minimum 3 character");
				} else if (input[1].matches(".*\\W.*") || input[1].matches(".*\\d.*")) {
					System.out.println("Alphabet only");
				}

			}

			// input user name
			while (true) {
				System.out.println("enter the user name");
				input[2] = scan.nextLine();
				
				if (cusDao.ValidatUsername(input[2])) {
					System.out.println("user name not available");
				} else if (input[2].matches("[a-zA-Z0-9]{8,20}")) {
					break;
				} else if (input[2].length() <= 7) {
					System.out.println("Must have 8 character or more");
				} else {
					System.out.println("special character not allowed");
				}
			}

			// input password
			while (true) {
				System.out.println("enter the password");
				input[3] = scan.nextLine();
				if (input[3].matches("[a-zA-Z0-9!@#$%^&*()_+]{8,20}")) {
					break;
				}
				System.out.println("Minimum 8 characters");
			}

			// input email
			while (true) {
				System.out.println("enter the email");
				input[4] = scan.nextLine().toLowerCase();
				if (cusDao.ValidateEmail(input[4])) {
					System.out.println("email not available ");
				} else if (input[4].matches("[a-z][a-z0-9.]*@[a-z0-9]+[.][a-z]{2,4}$")) {
					break;
				} else {
					System.out.println("email should contains @ and .");
				}
			}

			// input mobile number  
			while (true) {

				System.out.println("enter the mobile number");
				input[5] = scan.nextLine();
				if (input[5].matches("[6-9][0-9]{9}")) {
					break;
				} else if (input[5].matches("[0-5]")) {
					System.out.println("Number should start with 6 or above");
				} else if (input[5].matches(".*\\D.*")) {
					System.out.println("Accept number only");
				} else {
					System.out.println("length must be in 10 character");
				}
			}

			// input gender
			while (true) {
				System.out.println("male,female or others");
				input[6] = scan.nextLine().toLowerCase();
				if (input[6].equals("male") || input[6].equals("female") || input[6].equals("others")) {
					break;
				}
				System.out.println("invalid input");
			}

			// store the all the values in customer object
			Customers cus = new Customers(input[0], input[1], input[2], input[3], input[4], Long.parseLong(input[5]),
					input[6]);
			cusDao.insert(cus);
			

		// Login validation
		case 2:
			String userName = "";
			String password = "";

			// user name input
			while (true) {
				System.out.println("enter the username");
				userName = scan.nextLine();
				if (userName.matches("[a-zA-Z0-9]{8,20}")) {
					break;
				} else if (userName.length() <= 7) {
					System.out.println("Must have 8 character or more");
				} else {
					System.out.println("special character not allowed");
				}
			}

			// password input
			while (true) {
				System.out.println("enter the password");
				password = scan.nextLine();
				if (password.matches("[a-zA-Z0-9!@#$%^&*()_+]{8,20}")) {
					break;
				}
				System.out.println("invalid password");
			}

			// userName validation 
			Customers cusValidate = new Customers(userName, password);
			String valData = cusDao.cusValidation(cusValidate);

			// Checking user is avilable or not
			if (valData != null) {
				String name = valData.substring(1);
				// customer login
				if (valData.charAt(0) == '1') {
					System.out.println("welcome user: " + name);
					customer = cusDao.customerDetails(userName);
					System.out.println(customer);
					String choice=null;
				do {
				System.out.println("select operation");
				System.out.println("1.Profile updation\n2.Product options\n3.order operation\n4:cart operation");
				operation=Integer.parseInt(scan.nextLine());
				switch(operation) {
				case 1:
					CustomerMain customermain = new CustomerMain();
					customermain.customer(customer);
					break;
				case 2:
					 // to perform pet related operation
					PetMain petmain = new PetMain();
					petmain.petDetils(customer);
					break;
				case 3:
					// to order items
					OrderMain orderMain=new OrderMain();
					orderMain.orderMain(customer);
		            break;
				case 4:
					CartMain cartmain=new CartMain();
					cartmain.cartmain(customer);
					break;
				}
				System.out.println("do yo want continue yes/no");
				choice=scan.nextLine();
				}while(choice.equals("yes"));
				}

				// admin user login
				else {
					System.out.println("welcome Admin: " + userName);
					Admin admin = adminDao.show(userName);
					System.out.println(admin);
					AdminMain adminMain = new AdminMain();
					adminMain.adminMain(admin);
				}
			} 
			else {
				System.out.println("invalid user name or password");
			}
			break;
		}

	}

}
