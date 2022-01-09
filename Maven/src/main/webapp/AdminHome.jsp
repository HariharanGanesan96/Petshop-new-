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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://kit.fontawesome.com/aeca6704b2.js" crossorigin="anonymous"></script>
    
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
        <h1><i class="fas fa-paw" style="color: white;"></i> PET SHOP</h1>
        <input type="search" id="searchinput" placeholder="Enter pet category or name">
        <button id="search"><i class="fas fa-search" style="color: white"></i></button>
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
                                        <button type="button" onclick="UpdateStatus('<%=petDetails.getPetId() %>','approved')">accept</button>
                                        <button type="button" onclick="UpdateStatus('<%=petDetails.getPetId() %>','declined')">decline</button></a>
                                    </td>
                                </tr>
                            </tbody>
                        </table>  
                            
                    </td>
                       <% count ++;
                       if(count==2){ %> 
                    	   </tr>
                    	   <tr>              
                     <%count=0; }}%>  
                       
                </tr>
            </tbody>
        </table>
         
        </div>
    </div>
   </div>
      
   <script type="text/javascript">
   
   function UpdateStatus(petId,status){     
   
   	var url="UpdatePetStatus.jsp?petId="+petId+"&status="+status;  
   	
   	if(window.XMLHttpRequest){  
   		request=new XMLHttpRequest();  
   		}  
   		else if(window.ActiveXObject){  
   		request=new ActiveXObject("Microsoft.XMLHTTP");  
   		}  
   	try  
   	{  
   	request.onreadystatechange=getInfo;  
   	request.open("GET",url,true);  
   	request.send();  
   	}  
   	catch(e)  
   	{  
   	alert("Unable to connect to server");  
   	}
       }
      
    
   
   function getInfo(){  
   	if(request.readyState==4){  
   	var val=request.responseText;
   	 alert(val); 
   		location.reload();
   	}  
   	}  
  
 
   
   </script>
</body>
</html></html>