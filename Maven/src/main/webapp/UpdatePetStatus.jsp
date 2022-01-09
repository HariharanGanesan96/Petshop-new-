<%@page import="java.io.PrintWriter"%>
<%@page import="com.petshop.daoimpl.PetDAO"%>
<%@page import="com.petshop.model.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%int petId=Integer.parseInt(request.getParameter("petId"));
  String status=request.getParameter("status");
  Admin admin=(Admin) session.getAttribute("Admin");
  PetDAO petDao=new PetDAO();
  petDao.updateStatus(petId,status, admin.getAdminId());
  PrintWriter write=response.getWriter();
  write.print("Status Updated");
  %>
  

</body>
</html>