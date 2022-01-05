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
  customerDetails=(Customers)session.getAttribute("customer");
   String updateProfile=(String) session.getAttribute("updateProfile");%>
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
        <tbody>
            <tr>
            <form  onsubmit="return updateProfile();" action="UpdateProfile">
               <td rowspan="7"><img src="https://media1.popsugar-assets.com/files/thumbor/gMCOEkYB_3qTEDUrUbxtJkuusAA/fit-in/1024x1024/filters:format_auto-!!-:strip_icc-!!-/2017/07/12/947/n/1922153/c6f2e6f1596698606ad0d6.04019961_edit_img_image_15110365_1499895175/i/Chris-Hemsworth-Grooming-Interview.jpg" alt=""></td>
               <td><label for="firstname">FirstName</label></td>
               <td><input type="text" name="firstname" value="<%=customerDetails.getFirstName()%>" pattern="[a-zA-Z]{3,20}" required></td>
               <td><label for="lastname">LastName</label></td>
               <td><input type="text" name="lastname" value="<%=customerDetails.getLastName()%>" pattern="[a-zA-Z]+{3,20}" required></td>
            </tr>
            <tr>
                <td><label for="username"UserName>UserName</label></td>
                <td><input type="text" name="username" id="username" value="<%=customerDetails.getUserName()%>" pattern="[a-zA-Z0-9]{8,20}" required></td>
                <td><label for="gender">Gender</label></td>
                <td><input type="text" name="gender" value="<%=customerDetails.getGender()%>" pattern="[a-zA-Z]+{4,10}" required></td>
              </tr>
              <tr>
                <td><label for="email">Email</label></td>
                <td><input type="text" name="email" id="email" value="<%=customerDetails.getEmail()%>" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" required></td>
                <td><label for="number">number</label></td>
                <td><input type="text" name="number" value="<%=customerDetails.getNumber()%>" pattren="[6-9]{1}[0-9]{9}" required></td>
              </tr>
              <tr>
              <td><label for="password">Password</label></td>
              <td><input type="text" name="password" value="<%=customerDetails.getPassword()%>" pattern="[a-zA-Z0-9!@#$%^&*()_+]+{8,20}" required></td>
              <td> <button type="submit" id="update">Update Profile</button>  </td>
              <td><p id="updatemessage"></p><%=updateProfile %></td>  
              </form>
         
              </tr>
              <tr>
                <td><label for="address">Street</label></td>
                <td><input type="text" name="address" value="<%=customerDetails.getAddress()%>" required></td>
                <td><label for="city">City</label></td>
                <td><input type="text" name="city" value="<%=customerDetails.getCity()%>" required></td>
              </tr>
              <tr>
                <td><label for="pincode">pincode</label></td>
                <td><input type="text" name="pincode" value="<%=customerDetails.getPincode()%>" required>
                <td><button type="submit" id="update1" >Update Address</button> </td>
                <td><p></P></td>
              </tr>
              <tr>      

                <td><label for="wallet">wallet</label></td>
                <td><input type="text" name="wallet" value="<%=customerDetails.getWallet()%>" required></td>
                <td><button id="updatewallet"><a href="updatewallet">Add amount</a></button></td>
                <td></td>

        </tbody>
    </table>
</div>
</div>

</body>
</html>