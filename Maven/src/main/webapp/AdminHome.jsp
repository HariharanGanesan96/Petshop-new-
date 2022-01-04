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
       <link rel="stylesheet" href="AdminHome.css">
</head>
<body>
<%      List<PetDetails> petList=new ArrayList<PetDetails>();
        PetDetails pet=new PetDetails();
        PetDAO petdao=new PetDAO();      
        petList=petdao.showNotApprovedPetList();
       %>
    <div class="backgroundpage">
        <div class="head">
        <div class="navigation">
        <h1>PET Shop</h1>
        <input type="search" id="searchinput" placeholder="Enter pet category or name">
        <button id="search">search</button>
        <ul  id="menu">
        <li><a href="AdminProfile.jsp">My Profile</a></li>
        <li><a href="UserList.jsp">User List</a></li>
        <li><a href="AdminHome.jsp">Home</a></li>
        </ul>
        </div>
        
        <h2 class="petlist">Not Approved Pet List</h2>
        
        <div class="not approved list">
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
                                    <td><img src="<%=petDetails.getPetImage()%>" alt=""></td>    
                                    <td class="petdetails">
                                        <span>Type : <%=petDetails.getPetType()%> </span><br>
                                        <span>Name : <%=petDetails.getPetName()%>  </span><br>
                                        <span>Color : <%=petDetails.getPetColor()%> </span><br>
                                        <span>price : Rs.<%=petDetails.getPetprice() %> </span><br>
                                        <span>Qty: <%=petDetails.getAvilableQty() %></span><br>
                                        <span>Status: <%=petDetails.getStatus() %></span><br>
                                        <a href="UpdateStatus.jsp?petid=<%=petDetails.getPetId() %>"><button>accept</button></a>
                                         <a href="DeleteStatus.jsp?petid=<%=petDetails.getPetId() %>"><button>decline</button></a>
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