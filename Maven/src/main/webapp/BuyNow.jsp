 	<%@page import="java.io.PrintWriter"%>
<%@page import="com.petshop.daoimpl.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.petshop.daoimpl.PetDAO"%>
<%@page import="java.util.*"%>
<%@page import="com.petshop.model.*"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% 
   int quantity=Integer.parseInt(request.getParameter("quantity"));

   PetDetails pet=( PetDetails)session.getAttribute("pet");
   
   Customers customerDetails=(Customers)session.getAttribute("customer");

   PrintWriter write=response.getWriter();
   
   Orders orders=new Orders();
   OrdersDAO ordersDao=new OrdersDAO();
   OrderItems orderItems=new OrderItems();
   OrderItemsDAO orderItemsDao=new OrderItemsDAO();
   PetDAO petDao=new PetDAO();
   CustomerDAO customerDao=new CustomerDAO();
   
   Customers petCustomerDetails=customerDao.customerDetails(pet.getCustomer().getCustomerId());
 
   if(customerDetails.getWallet()>(quantity*pet.getPetprice())){  
	   if(pet.getAvilableQty()>=quantity){	   
   orders.getCustomer().setCustomerId(customerDetails.getCustomerId());
   orders.setTotalprice((quantity*pet.getPetprice()));
   
   // insert values in orders
   ordersDao.insert(orders);
     
   int orderId=ordersDao.orderId();  
   orderItems.getOrders().setOrderId(orderId);
   orderItems.getPet().setPetId(pet.getPetId());
   orderItems.setQuantity(quantity);
   orderItems.setUnitPrice(pet.getPetprice());
   orderItems.setTotalPrice((quantity*pet.getPetprice()));
   
   // insert the values in order items
   orderItemsDao.insert(orderItems);
   
   //update pet available quantity
   pet.setAvilableQty((pet.getAvilableQty()-quantity));
   petDao.updatePetAviQty(pet);
   
   //update buyer wallet
   customerDetails.setWallet(customerDetails.getWallet()-(quantity*pet.getPetprice()));
   customerDao.updateWallet(customerDetails);
   
   //update seller wallet
   petCustomerDetails.setWallet(petCustomerDetails.getWallet()+(quantity*pet.getPetprice()));
   customerDao.updateWallet(petCustomerDetails);
   
   write.print("order placed sucussfully \n Current wallet Balance :"+customerDetails.getWallet()+"");
   }
	   else{
		   write.print("Quantity not avilable");
	   }
   }
   
   else{
	   write.print("low Wallet balance");
   }
  
  %>
