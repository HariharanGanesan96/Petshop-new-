<%@page import="java.io.PrintWriter"%>
<%@page import="com.petshop.daoimpl.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.petshop.daoimpl.*"%>
<%@page import="java.util.*"%>
<%@page import="com.petshop.model.*"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
   Double totalPrice=Double.parseDouble(request.getParameter("totalCartAmount"));

   List<CartItems> cartList=(List<CartItems>) request.getAttribute("cartList");
 
   Customers customerDetails=(Customers)session.getAttribute("customer");
   
   PrintWriter write=response.getWriter();
   
   PetDAO petDao=new PetDAO();
   CustomerDAO customerDao=new CustomerDAO();
   Orders orders=new Orders();
   OrdersDAO ordersDao=new OrdersDAO();
   OrderItems orderItems=new OrderItems();
   OrderItemsDAO orderItemsDao=new OrderItemsDAO(); 
   
   boolean flage=true;
   if(customerDetails.getWallet()>=totalPrice){
	   for(CartItems cartItems: cartList){
		   PetDetails petDetails=petDao.showPet(cartItems.getPet().getPetId());
		   if(petDetails.getAvilableQty()<cartItems.getQuantity()){
			   flage=false;
			   write.print("Quantity not Avialble item Id "+cartItems.getItemId());
		   }
	   }
   if(flage){
   orders.getCustomer().setCustomerId(customerDetails.getCustomerId());
   orders.setTotalprice(totalPrice);
   ordersDao.insert(orders);

   int orderId=ordersDao.orderId();
   
   for(CartItems cartItems: cartList){
   
   orderItems.getOrders().setOrderId(orderId);
   orderItems.getPet().setPetId(cartItems.getPet().getPetId());
   orderItems.setQuantity(cartItems.getQuantity());
   orderItems.setUnitPrice(cartItems.getUnitPrice());
   orderItems.setTotalPrice(cartItems.getTotalPrice());
   orderItemsDao.insert(orderItems);
   
   PetDetails petDetails=petDao.showPet(cartItems.getPet().getPetId());
   
   //update pet available quantity
   petDetails.setAvilableQty((petDetails.getAvilableQty()-cartItems.getQuantity()));
   petDao.updatePetAviQty(petDetails);
     
   //update seller wallet
   Customers petCustomerDetails=customerDao.customerDetails(petDetails.getCustomer().getCustomerId());
   petCustomerDetails.setWallet(petCustomerDetails.getWallet()+(cartItems.getTotalPrice()));
   customerDao.updateWallet(petCustomerDetails);
   
   } 
   //update buyer wallet
   customerDetails.setWallet(customerDetails.getWallet()-totalPrice);
   customerDao.updateWallet(customerDetails);
   }
   }
   else{
	   write.print("wallet balance is low");
   }
   %>
</body>
</html>