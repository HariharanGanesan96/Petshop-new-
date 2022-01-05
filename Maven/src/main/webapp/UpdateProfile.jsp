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
<%       boolean flag=false;
         PrintWriter write=response.getWriter();
         Customers customerDetails=(Customers)session.getAttribute("customer");
         CustomerDAO customerDao=new CustomerDAO();
               
         String userName=request.getParameter("username");
         flag=customerDao.ValidatUsername(userName);
         
         System.out.println();
         System.out.println(userName);
         System.out.println(customerDetails.getUserName());
         
         if(flag==true && (userName!=customerDetails.getUserName())){
        	 write.print("username not available");
        	 System.out.println("username not available");
         }
         
         String email=request.getParameter("email");
         flag=customerDao.ValidateEmail(email);
         
         if(flag==true && (email!=customerDetails.getEmail())){
        	 write.print("Email not available");
        	 System.out.println("username not available"); 
         }
         
    
         
         if(flag!=true){
         write.print("nodata");
         System.out.println("data"); 
         }
         %>
</body>
</html>