package com.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dao.CustomerDao;
import com.dao.PetDao;
import com.model.Admin;
import com.model.Customers;
import com.model.PetDetails;

public class AdminMain {
	
	public void adminMain(Admin admin) throws ClassNotFoundException, SQLException {
		
		
		CustomerDao cusDao=null;
		Scanner scan=new Scanner(System.in);
		String choice="";
		do {
		System.out.println("1.list of all user and delete user\n"
	                     + "2.List of all request (accept or decline)\n"
				         +"3.Logout");
		int adminOperation=Integer.parseInt(scan.nextLine());
		switch(adminOperation) {
		
		// list of all user
		case 1:	
			String deleteChoice;
			do {
			cusDao.showCustomerList();			
			System.out.println("Do you want delete customer yes/No");
			choice=scan.nextLine().toLowerCase();
			if(choice.equals("yes")) {
				System.out.println("Enter the customer id need to delete");
				int cusid=Integer.parseInt(scan.nextLine());
			Customers customer=new Customers();
			customer.setCustomerId(cusid);
				cusDao.delete(customer);	
			}
			else {
				System.out.println("Choice other operation");
			}
			System.out.println("Do you want delete user yes/no");
			deleteChoice=scan.nextLine().toLowerCase();
			}while(deleteChoice.equals("yes"));
			break;		
			
			
		// update status	
		case 2:
			// 
			PetDao petlDao=new PetDao();
			
			char c;
			do {
			petlDao.showNotApprovedPetList();
			System.out.println("update status");
			System.out.println("enter the Pet id");
			int petId=Integer.parseInt(scan.nextLine());
			System.out.println("enter the status");
			System.out.println("approved or decline");
			String status=scan.nextLine();
			System.out.println(admin.getAdminId());
			System.out.println(petId);
			System.out.println(status);
			petlDao.updateStatus(petId, status,admin.getAdminId());
			System.out.println("do you want continue y/n");
			c=scan.nextLine().toLowerCase().charAt(0);
			}while(c=='y');	
		
		// logout
		case 3:
			System.exit(0);
			break;
		}
		System.out.println("do you want contine yes/no");
	    choice=scan.nextLine().toLowerCase();
		}while(choice.equals("yes"));
		scan.close();
	}

}
