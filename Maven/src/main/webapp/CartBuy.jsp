<%@page import="java.io.PrintWriter"%>
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
	int itemId = Integer.parseInt(request.getParameter("itemId"));
	session = request.getSession();
	PrintWriter write = response.getWriter();
	CartItemsDAO cartDao = new CartItemsDAO();
	CartItems cartItems = cartDao.showCart(itemId);

	Customers customerDetails = (Customers) session.getAttribute("customer");
	Orders orders = new Orders();
	OrdersDAO ordersDao = new OrdersDAO();
	OrderItems orderItems = new OrderItems();
	OrderItemsDAO orderItemsDao = new OrderItemsDAO();
	PetDAO petDao = new PetDAO();

	PetDetails pet = petDao.showPet(cartItems.getPet().getPetId());
	CustomerDAO customerDao = new CustomerDAO();
	Customers petCustomerDetails = customerDao.customerDetails(pet.getCustomer().getCustomerId());

	if (customerDetails.getWallet() > (cartItems.getTotalPrice())) {
		if (pet.getAvilableQty() >= cartItems.getQuantity()) {

			orders.getCustomer().setCustomerId(customerDetails.getCustomerId());
			orders.setTotalprice(cartItems.getTotalPrice());

			// insert values in orders
			ordersDao.insert(orders);

			int orderId = ordersDao.orderId();
			orderItems.getOrders().setOrderId(orderId);
			orderItems.getPet().setPetId(pet.getPetId());
			orderItems.setQuantity(cartItems.getQuantity());
			orderItems.setUnitPrice(pet.getPetprice());
			orderItems.setTotalPrice(cartItems.getTotalPrice());

			// insert the values in order items
			orderItemsDao.insert(orderItems);

			//update pet available quantity
			pet.setAvilableQty((pet.getAvilableQty() - cartItems.getQuantity()));
			petDao.updatePetAviQty(pet);

			//update buyer wallet
			customerDetails.setWallet(customerDetails.getWallet() - cartItems.getTotalPrice());
			customerDao.updateWallet(customerDetails);

			//update seller wallet
			petCustomerDetails.setWallet(petCustomerDetails.getWallet() + cartItems.getQuantity());
			customerDao.updateWallet(petCustomerDetails);

			cartDao.delete(cartItems.getItemId());
			write.print("order placed sucussfully");
		} else {

			write.print("Quantity not avilable");
		}
	}

	else {
		write.print("low Wallet balance");
	}
	%>
</body>
</html>