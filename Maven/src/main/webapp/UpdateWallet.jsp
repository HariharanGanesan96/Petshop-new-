<%@page import="java.io.PrintWriter"%>
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
boolean message=true;
 PrintWriter write1=response.getWriter();
if(wallet<=0){
     write1.print("Inavlid Amount");
   message=false;
}
if(message){
Customers customer=(Customers)session.getAttribute("customer");
customer.setWallet(customer.getWallet()+wallet);
CustomerDAO customerDao=new CustomerDAO();
customerDao.updateWallet(customer);
write1.print("Amount Added");
}
%>
</body>
</html>