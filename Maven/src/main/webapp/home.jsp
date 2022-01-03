<%@page import="com.petshop.daoimpl.PetDAO"%>
<%@page import="java.util.*"%>
<%@page import="com.petshop.model.*"%>
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
<%      List<PetDetails> petList=new ArrayList<PetDetails>();
        PetDetails pet=new PetDetails();
        PetDAO petdao=new PetDAO();      
        petList=petdao.showAllpets();
       %>
    <div class="backgroundpage">
        <div class="head">
        <div class="navigation">
        <h1>PET Shop</h1>
        <input type="search" id="searchinput" placeholder="Enter pet category or name">
        <button id="search">search</button>
        <ul  id="menu">
        <li><a href="myprofile.jsp">My Profile</a></li>
        <li><a href="mycart.jsp">My cart</a></li>
        <li><a href="myorders.jsp">My orders</a></li>
        <li><a href="AddItem.jsp">Add item</a></li>
        <li><a href="home.jsp">Home</a></li>
        </ul>
        </div>
        
        
        <h2 class="petlist">Pet List</h2>
        
        <div class="recently added list">
        <table>
            <tbody>
                <tr>
                <%int count=0;
                for(PetDetails petDetails: petList){
                	%>
                    <td>
                        <table id="pets">
                            <tbody>
                                <tr>
                                    <td><img src="<%=petDetails.getPetImage()%>" alt="petimage"></td>    
                                    <td class="petdetails">
                                        <span>Type : <%=petDetails.getPetType()%> </span><br>
                                        <span>Name : <%=petDetails.getPetName()%>  </span><br>
                                        <span>Color : <%=petDetails.getPetColor()%> </span><br>
                                        <span>price : Rs.<%=petDetails.getPetprice() %> </span><br>
                                        <span>Qty: <%=petDetails.getAvilableQty() %></span><br>
                                        <a href="PetDescription.jsp?petid=<%=petDetails.getPetId() %>"><button>view</button></a>
                                    </td>
                                </tr>
                            </tbody>
                        </table>  
                        
                            
                    </td>
                       <% count ++;
                       if(count==3){ %> 
                    	   </tr>
                    	   <tr>              
                     <%count=0; }}%>  
                       
                </tr>
            </tbody>
        </table>
         
        </div>
    </div>
   </div>
</body>
</html></html>