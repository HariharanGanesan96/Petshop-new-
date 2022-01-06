<%@page import="com.petshop.daoimpl.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.petshop.daoimpl.*"%>
<%@page import="com.petshop.model.*"%>
<%@page import="java.util.*"%>
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
	Customers customerDetails=(Customers) session.getAttribute("customer");
	String petType = request.getParameter("animaltype");
	String petName = request.getParameter("animalname");
	String petGender = request.getParameter("animalgender");
	String petDob = request.getParameter("dob");
	SimpleDateFormat formet = new SimpleDateFormat("dd-mm-yyyy");
	Date date = formet.parse(petDob);
	String petColor = request.getParameter("color");
	double petPrice = Double.parseDouble(request.getParameter("price"));
	String petImage = request.getParameter("imagelink");
	String petDescription = request.getParameter("description");
	int petQty = Integer.parseInt(request.getParameter("quantity"));
	PetDetails petDetails = new PetDetails();
	PetDAO petDao=new PetDAO();
	petDetails.setPetType(petType);
	petDetails.setPetName(petName);
	petDetails.setPetGender(petGender);
	petDetails.setPetDob(date);
	petDetails.setPetColor(petColor);
	petDetails.setPetprice(petPrice);
	petDetails.setPetImage(petImage);
	petDetails.setDescription(petDescription);
	petDetails.setPetQty(petQty);
	petDetails.setAvilableQty(petQty);
	petDetails.getCustomer().setCustomerId(customerDetails.getCustomerId());
	petDao.insert(petDetails);	
	petDetails.setPetColor(petColor);
	response.sendRedirect("AddItem.jsp");
	%>
</body>
</html>