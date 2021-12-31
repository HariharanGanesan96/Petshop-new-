<%@page import="com.petshop.daoimpl.PetDAO"%>
<%@page import="com.petshop.controller.login"%>
<%@page import="com.petshop.model.Customers"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My profile</title>
     <link rel="stylesheet" href="myprofile.css">
</head>
<body>
  <%Customers customerDetails=new Customers();
  customerDetails=(Customers)session.getAttribute("customer");%>
   <div class="background">
    <div class="navigation">
    <h1>PET Shop</h1>
    <ul  id="menu">
    <li><a href="">My Profile</a></li>
    <li><a href="">My cart</a></li>
    <li><a href="">My orders</a></li>
    <li><a href="">Add item</a></li>
    <li><a href="">Home</a></li> 
    </ul>
    </div>
    <form action="updateprofile">
    <table>
        <tbody>
            <tr>
               <td rowspan="6"><img src="https://media1.popsugar-assets.com/files/thumbor/gMCOEkYB_3qTEDUrUbxtJkuusAA/fit-in/1024x1024/filters:format_auto-!!-:strip_icc-!!-/2017/07/12/947/n/1922153/c6f2e6f1596698606ad0d6.04019961_edit_img_image_15110365_1499895175/i/Chris-Hemsworth-Grooming-Interview.jpg" alt=""></td>
               <td><label for="firstname">FirstName</label></td>
               <td><input type="text" name="firstname" value="<%=customerDetails.getFirstName()%>"></td>
               <td><label for="lastname">LastName</label></td>
               <td><input type="text" name="lastname" value="<%=customerDetails.getLastName()%>"></td>
            </tr>
            <tr>
                <td><label for="username"UserName>UserName</label></td>
                <td><input type="text" name="username" value="<%=customerDetails.getUserName()%>"></td>
                <td><label for="gender">Gender</label></td>
                <td><input type="text" name="gender" value="<%=customerDetails.getGender()%>"></td>
              </tr>
              <tr>
                <td><label for="email">Email</label></td>
                <td><input type="text" name="email" value="<%=customerDetails.getEmail()%>"></td>
                <td><label for="number">number</label></td>
                <td><input type="text" name="number" value="<%=customerDetails.getNumber()%>"></td>
              </tr>
              <tr>
                <td><label for="address">Street</label></td>
                <td><input type="text" name="address" value="<%=customerDetails.getAddress()%>"></td>
                <td><label for="city">City</label></td>
                <td><input type="text" name="city" value="<%=customerDetails.getCity()%>"></td>
              </tr>
              <tr>
                <td><label for="pincode">pincode</label></td>
                <td><input type="text" name="pincode" value="<%=customerDetails.getPincode()%>">
                <td></td>
                <td></td>
              </tr>
              <tr>
                <td><label for="wallet">wallet</label></td>
                <td><input type="text" name="wallet" value="<%=customerDetails.getWallet()%>"></td>
                <td><button id="updatewallet"><a href="updatewallet">Add amount</a></button></td>
                <td></td>
              
        </tbody>
    </table>
    <button type="submit" id="update">Update</button>
</form>
</div>
</body>
</html>