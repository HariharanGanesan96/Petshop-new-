<%@page import="com.petshop.daoimpl.OrderItemsDAO"%>
<%@page import ="java.sql.ResultSet"%>
<%@page import="com.petshop.model.Customers"%>

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
Customers customerDetails=new Customers();
  customerDetails=(Customers)session.getAttribute("customer");
  OrderItemsDAO orderItemDao=new OrderItemsDAO();
  ResultSet rs=orderItemDao.showMyOrders(customerDetails);
%>

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