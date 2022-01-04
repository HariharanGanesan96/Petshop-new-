<%@page import="com.petshop.model.*"%>
<%@page import="com.petshop.daoimpl.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Orders</title>
<link rel="stylesheet" href="MyOrders.css">
<style type="text/css">
table{
margin-top: 40px;}
</style>
</head>
<body>
<%
  Customers customerDetails=new Customers();
  CustomerDAO customerDao=new CustomerDAO();
  List<Customers> customerList=customerDao.showCustomerList();
		  
%>
       <div class="navigation">
        <h1>PET Shop</h1>
        <ul  id="menu">
        <li><a href="AdminProfile.jsp">My Profile</a></li>
        <li><a href="UserList.jsp">User List</a></li>
        <li><a href="AdminHome.jsp">Home</a></li>
        </ul>
        </div>

<table>
<thead>
<tr>
<th>Id</th>
<th>First Name</th>
<th>Last Name</th>
<th>Gender</th>
<th>User Name </th>
<th>Email</th>
<th>Number</th>
</tr>
</thead>
<tbody>
<%for(Customers customer:customerList){ %>
<tr>
<td><%=customer.getCustomerId()%></td>
<td><%=customer.getFirstName()%></td>
<td><%=customer.getLastName()%></td>
<td><%=customer.getGender()%></td>
<td><%=customer.getUserName()%></td>
<td><%=customer.getEmail()%></td>
<td><%=customer.getNumber()%></td>
</tr>
<%} %>
</tbody>
</table>
</body>
</html>