package com.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dao.CartItemsDao;
import com.dao.OrderItemsDao;
import com.dao.OrdersDao;
import com.dao.PetDao;
import com.exception.QtyNotAvalilable;
import com.model.CartItems;
import com.model.Customers;
import com.model.OrderItems;
import com.model.Orders;
import com.model.PetDetails;

public class OrderMain {

	public void orderMain(Customers customer) throws ClassNotFoundException, SQLException {
		Scanner scan = new Scanner(System.in);
		PetDao petDao = new PetDao();
		OrdersDao ordersDao = new OrdersDao();
		OrderItemsDao orderItemsDao = new OrderItemsDao();
		String choice;
		int back=0;
		do {
			
			System.out.println("1.order \n2.myorders\n3.cancel order\n4.back");

			int operation = Integer.parseInt(scan.nextLine());
			switch (operation) {

			case 1:
				petDao.showAllpets();
				// list is used to store temporary orderitems data

				List<OrderItems> itemlist = new ArrayList<OrderItems>();
				// Asking for add items
				double sum = 0;
				do {
					System.out.println("enter pet id need to order");
					int petId = Integer.parseInt(scan.nextLine());
					PetDetails petdetails = petDao.showPet(petId);
					System.out.println("enter the quantity");
					int qty = Integer.parseInt(scan.nextLine());
					// checking for qty matching
					if (petdetails.getAvilableQty() < qty) {
						try {
							
					    throw new QtyNotAvalilable("Quantity not available");
					}
						catch (QtyNotAvalilable e) {
							System.out.println(e);
						}
					}
					// if quantity matched its do update operation
					else {
						petdetails.setAvilableQty((petdetails.getAvilableQty()) - qty);
						petDao.updatePetAviQty(petdetails);
						// store the values in list
						OrderItems ordersItem = new OrderItems(petId, qty, petdetails.getPetprice(),
								(qty * petdetails.getPetprice()));
						itemlist.add(ordersItem);
						sum += qty * petdetails.getPetprice();
					}
					System.out.println("do you want Continue yes/no");
					choice = scan.nextLine();
				} while (choice.equals("yes"));

				// insert the values in order items
				Orders order = new Orders(customer.getCustomerId(), sum);
				ordersDao.insert(order);

				// insert the value in orderitems
				int orderId = ordersDao.orderId();
				for (OrderItems i : itemlist) {
					i.setOrderId(orderId);
					orderItemsDao.insert(i);
				}

				break;
			// show my order items
			case 2:
				orderItemsDao = new OrderItemsDao();
				orderItemsDao.showMyOrders(customer);
				break;
           
				// cancel order
			case 3:
				orderItemsDao.showMyOrders(customer);
				do {
				System.out.println("enter the order id to cancel order");
				orderId=Integer.parseInt(scan.nextLine());
				List<OrderItems> updateList=new ArrayList<OrderItems>();
			    updateList=orderItemsDao.getCurrentOrder(orderId);
			    for(OrderItems oi:updateList) {
			    	
			    	 PetDetails pet=new PetDetails();
			    	 pet.setPetId(oi.getPetId());
			    	 pet.setAvilableQty(pet.getAvilableQty()+oi.getQuantity());
					    petDao.updatePetAviQty(pet);
			    }
			   
				ordersDao.updateStatus(orderId);
				System.out.println("do want continue yes/no");
				choice=scan.nextLine();
				}while(choice.equals("yes"));
				break;
			case 4:
				back++;
				break;
			}
			if(back==1) {
				break;
			}
			System.out.println("do you want continue yes/no");
			choice = scan.nextLine().toLowerCase();
		} while (choice.equals("yes"));
	}
}
