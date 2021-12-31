<%@page import="com.dao.PetDao"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
       <link rel="stylesheet" href="home.css">
</head>
<body>
    <div class="background">
        <div class="head">
        <div class="navigation">
        <h1>PET Shop</h1>
        <input type="search" id="searchinput" placeholder="Enter pet category or name">
        <button id="search">search</button>
        <ul  id="menu">
        <li><a href="myprofile1.jsp">My Profile</a></li>
        <li><a href="mycart.jsp">My cart</a></li>
        <li><a href="myorders.jsp">My orders</a></li>
        <li><a href="additem.jsp">Add item</a></li>
        <li><a href="home.jsp">Home</a></li>
        </ul>
        </div>
        <div class="animalscategory">
            <h2>Top category</h2>
            <button id="dog" title="dog">Dog</button>
            <button id="cat" title="cat">Cat</button>
            <button id="birds" title="birds">Birds</button>
            <button id="fish" title="fish">Fish</button>
        </div>
       <div>
       <%PetDao petdao=new PetDao(); 
           petdao.showAllpets();%>
       </div>
    </div>
    </div>
</body>
</html></html>