<%@page import="java.io.PrintWriter"%>
<%@page import="com.petshop.daoimpl.*"%>
<%@page import ="java.util.*"%>
<%@page import="com.petshop.model.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
Orders order=new Orders();
OrdersDAO orderDao=new OrdersDAO();
int orderId=Integer.parseInt(request.getParameter("orderId"));
order.setOrderId(orderId);
orderDao.updateStatus(order);
PrintWriter write=response.getWriter();
write.print("order cancelld");
%>