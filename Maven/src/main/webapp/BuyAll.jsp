<%@page import="com.petshop.daoimpl.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.petshop.daoimpl.PetDAO"%>
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
   List<CartItems> cartList=(List) request.getAttribute("cartList");
   PetDetails pet=( PetDetails)session.getAttribute("pet");
   Customers customerDetails=(Customers)session.getAttribute("customer");
   
   Orders orders=new Orders();
   OrdersDAO ordersDao=new OrdersDAO();
   OrderItems orderItems=new OrderItems();
   OrderItemsDAO orderItemsDao=new OrderItemsDAO(); 
   
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
   }
   %>
</body>
</html>