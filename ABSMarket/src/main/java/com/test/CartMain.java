package com.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dao.CartItemsDao;
import com.dao.PetDao;
import com.model.CartItems;
import com.model.Customers;
import com.model.PetDetails;

public class CartMain {
	
	public void cartmain(Customers customer) throws ClassNotFoundException, SQLException {
		 
		PetDao petDao = new PetDao();
		Scanner scan=new Scanner(System.in);
		String choice = null;
		int back=0;
		do {
			System.out.println("1.add items to cart\n2.show my cart item and delete cart item\n 3.update cart item\n4.back");
			int operation=Integer.parseInt(scan.nextLine());
		switch(operation) {
		// to add item into carts
					case 1:
						// to show all values
						petDao.showAllpets();
						// cartitems dao created for to access metods
						CartItemsDao cartItemsDao = new CartItemsDao();
						double totalPrice = 0;
						do {
							System.out.println("enter pet id to add cart");
							int petId = Integer.parseInt(scan.nextLine());
							PetDetails petdetails = petDao.showPet(petId);
							System.out.println("enter the quantity");
							int qty = Integer.parseInt(scan.nextLine());

							if (petdetails.getAvilableQty() < qty) {
								System.out.println("invalid quantity");
							}

							else {
								petdetails.setAvilableQty((petdetails.getAvilableQty()) - qty);
								petDao.updatePetAviQty(petdetails);
								CartItems cartItem = new CartItems(petId, customer.getCustomerId(), qty,
										petdetails.getPetprice(), (qty * petdetails.getPetprice()));

								totalPrice += qty * petdetails.getPetprice();
								cartItemsDao.insert(cartItem);
							}
							System.out.println("do you want Continue yes/no");
							choice = scan.nextLine();
						} while (choice.equals("yes"));
						break;
					// show my cart items
					case 2:
						List<CartItems> cartList = new ArrayList<CartItems>();
						cartItemsDao = new CartItemsDao();
						cartList = cartItemsDao.show(customer);
						for (CartItems c : cartList) {
							System.out.println(c);
						}
						System.out.println("do you want delete item yes/no");
						String deleteChoice = scan.nextLine().toLowerCase();
						while (deleteChoice.equals("yes")) {
							System.out.println("enter the item id for delete");
							int itemId = Integer.parseInt(scan.nextLine());
							cartItemsDao.delete(itemId);
							System.out.println("do you want delete item yes/no");
							deleteChoice = scan.nextLine().toLowerCase();
						}

						break;
					// update cart item
				
					case 3:
						cartList = new ArrayList<CartItems>();
						cartItemsDao = new CartItemsDao();
						String updateChoice="";
						do {
						cartList = cartItemsDao.show(customer);
						for (CartItems c : cartList) {
							System.out.println(c);
						}													
							System.out.println("enter the item id for update");
							int itemId = Integer.parseInt(scan.nextLine());
							System.out.println("enter the qty for updating");
							int qty=Integer.parseInt(scan.nextLine());
							cartItemsDao.updateQty(itemId,qty);
							System.out.println("do you want update item yes/no");
							updateChoice = scan.nextLine().toLowerCase();
						}while(updateChoice.equals("yes"));
						
						break;
					// back
					case 4:
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
