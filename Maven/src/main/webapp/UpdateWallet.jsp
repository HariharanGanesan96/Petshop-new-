<%@page import="com.petshop.model.*"%>
<%@page import="com.petshop.daoimpl.*"%>
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
double wallet=Integer.parseInt(request.getParameter("wallet"));
Customers customer=(Customers)session.getAttribute("customer");
customer.setWallet(customer.getWallet()+wallet);
CustomerDAO customerDao=new CustomerDAO();
customerDao.updateWallet(customer);
session.setAttribute("message","Wallet updated");
response.sendRedirect("myprofile.jsp");
%>
</body>
</html>