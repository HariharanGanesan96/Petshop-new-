<%@page import="com.petshop.daoimpl.OrderItemsDAO"%>
<%@page import ="java.sql.ResultSet"%>
<%@page import="com.petshop.model.Customers"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Orders</title>
<link rel="stylesheet" href="MyOrders.css">
</head>
<body>
<%
  Customers customerDetails=new Customers();
  customerDetails=(Customers)session.getAttribute("customer");
  OrderItemsDAO orderItemDao=new OrderItemsDAO();
  ResultSet rs=orderItemDao.showMyOrders(customerDetails);
%>
        <div class="head">
        <div class="navigation">
        <h1>PET Shop</h1>
        <ul  id="menu">
        <li><a href="myprofile.jsp">My Profile</a></li>
        <li><a href="mycart.jsp">My cart</a></li>
        <li><a href="myorders.jsp">My orders</a></li>
        <li><a href="AddItem.jsp">Add item</a></li>
        <li><a href="home.jsp">Home</a></li>
        </ul>
        </div>
        </div>

<table>
<thead>
<tr>
<th>Order id</th>
<th>Pet id</th>
<th>Pet name</th>
<th>Unit_price</th>
<th>Quantity</th>
<th>Total price</th>
<th>Status</th>
<th>Order date</th>	
</tr>
</thead>
<tbody>
<%while(rs.next()){ %>
<tr>
<td><%=rs.getInt(1)%></td>
<td><%=rs.getInt(2)%></td>
<td><%=rs.getString(3)%></td>
<td><%=rs.getDouble(4)%></td>
<td><%=rs.getInt(5)%></td>
<td><%=rs.getDouble(6)%></td>
<td><%=rs.getString(7)%></td>
<td><%=rs.getDate(8)%></td>
</tr>
<%} %>
</tbody>
</table>
</body>
</html>