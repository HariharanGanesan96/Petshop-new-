package Main;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

import com.ABSClass.Customers;
import com.Dao.CustomerDao;

public class TestMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Scanner scan = new Scanner(System.in);

		System.out.println("choice your table to operate");

		int userinput = Integer.parseInt(scan.nextLine());

		switch (userinput) {
		case 1:
			System.out.println("Enter the operation");
			System.out.println("1.insert values" + "\n" + "2.login validation" + "\n" + "3.bank and address updataion"
					+ "\n" + "4.delete" + "\n" + "5.list of user");
			int operation = Integer.parseInt(scan.nextLine());

			switch (operation) {
			case 1:
				CustomerDao cusdao = new CustomerDao();
				String[] input = new String[7];

				while(true) {
					System.out.println("enter the first name");
					input[0] = scan.nextLine();
					if (input[0].matches("[a-zA-Z]{3,20}") == true) {
						break;
					} 
					if(input[0].length()<=2){
						System.out.println("lastname must have minimum 3 character");
					}
					else if(input[0].matches(".*\\W.*")||input[0].matches(".*\\d.*")) {
						System.out.println("name contains alphabet only");
					}
				}
				while(true) {
					System.out.println("enter the last name");
					input[1] = scan.nextLine();
					if (input[1].matches("[a-zA-Z]{3,20}") == true) {
						break;
					} 
					if(input[1].length()<=2){
						System.out.println("lastname must have minimum 3 character");
					}
					else if(input[1].matches(".*\\W.*")||input[1].matches(".*\\d.*")) {
						System.out.println("name contains alphabet only");
					}
					
				}
				while(true) {
					System.out.println("enter the user name");
					input[2] = scan.nextLine();
					if(cusdao.ValidatUsername(input[2])== false) {
						System.out.println("user name not available");
					}
					else if (input[2].matches("[a-zA-Z0-9]{8,20}") == true) {
						break;
					}
					else if(input[2].length()<=7){
						System.out.println("username must be minimum 8 character or more");
					  }
					
					else {
						System.out.println("Don't use special for username");
					}
				}
				while(true) {	
					System.out.println("enter the password");
					input[3] = scan.nextLine();
					if (input[3].matches("[a-zA-Z0-9!@#$%^&*()_+]{8,20}") == true) {
					break;
					} 
					System.out.println("password nust be in 8 charcter or more");
				}
			
				while(true) {
					System.out.println("enter the email");
					input[4] = scan.nextLine().toLowerCase();
					if(cusdao.ValidateEmail(input[4])== false) {
						System.out.println("email not available ");
					}
					else if (input[4].matches("[a-z0-9._%+-]+@[a-z0-9.-]+[.][a-z]{2,4}$") == true) {
						break;
					} 
					else {
					System.out.println("email should contains @ and .");
				}
				}
				while(true) {
					
					System.out.println("enter the mobile number");
					input[5] = scan.nextLine();
					if (input[5].matches("[6-9][0-9]{9}") == true) {
						break;
					} 
					else if(input[5].matches("[0-5]")) {
						System.out.println("mobile numst be start with 6 or above");
					}
					if(input[5].matches(".*\\D.*")) {
						System.out.println("Accept number only");
					}
					
					
				}
				while(true) {
						System.out.println("male,female or others");
						input[6] = scan.nextLine().toLowerCase();
						if (input[6].equals("male") || input[6].equals("female") || input[6].equals("others")) {
							break;
						}
						System.out.println("invalid input");
					}
					
				Customers cus = new Customers( input[0], input[1], input[2], input[3],
						input[4], Long.parseLong(input[5]),input[6]);
				cusdao.insert(cus);
				break;
			case 2:
				System.out.println("enter the username");
				String username = scan.nextLine();
				System.out.println("enter the password");
				String password = scan.nextLine();
				Customers cusvalidate = new Customers(username, password);
				CustomerDao cusdaoval = new CustomerDao();
				String valdata = cusdaoval.cusValidation(cusvalidate);
				if (valdata != null) {
					if (valdata.charAt(0) == '1') {
						System.out.println("welcome user" + valdata);
					} else {
						System.out.println("welcome Admin" + valdata);
					}
				} else {
					System.out.println("invalid user name or password");
				}
				break;
			case 3:
				System.out.println("enter the bank account number");
				long bankAccount = Long.parseLong(scan.nextLine());
				System.out.println("enter the address");
				String address = scan.nextLine();
				System.out.println("enter the pincode");
				int pincode = Integer.parseInt(scan.nextLine());
				System.out.println("enter the customer_id");
				int cusid = Integer.parseInt(scan.nextLine());
				Customers cusupdate = new Customers(cusid, bankAccount, address, pincode);
				CustomerDao cusdaoup = new CustomerDao();
				cusdaoup.update(cusupdate);
				break;

			}

			break;
		case 2:

			break;
		case 3:

			break;
		case 4:

			break;
		case 5:

			break;
		default:
			System.out.println("invalid input");
			break;

		}

	}

}
