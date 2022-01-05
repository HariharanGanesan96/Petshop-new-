<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.petshop.daoimpl.PetDAO"%>
<%@page import="java.util.*"%>
<%@page import="com.petshop.model.*"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
  <link rel="stylesheet" href="PetDescription.css">
</head>
<body>
     <% //List<PetDetails> petList=new ArrayList<PetDetails>();
        PetDetails pet=new PetDetails();
        PetDAO petdao=new PetDAO();      
        int petid=Integer.parseInt(request.getParameter("petid"));
        pet=petdao.showPet(petid);
        session.setAttribute("pet", pet);
        
        SimpleDateFormat formet=new SimpleDateFormat("dd-mm-yyyy");
        Date date=pet.getPetDob();
        String dob=formet.format(date);
        session.setAttribute("message", " ");
       %>
       <div class="head">
        <div class="navigation">
        <h1>PET Shop</h1>
        <ul  id="menu">
        <li><a href="myprofile.jsp">My Profile</a></li>
        <li><a href="mycart.jsp">My cart</a></li>
        <li><a href="myorders.jsp">My orders</a></li>
        <li><a href="additem.jsp">Add item</a></li>
        <li><a href="home.jsp">Home</a></li>
        </ul>
        </div>
       <table>
        <tbody>
            <tr>
               <td><img src="<%=pet.getPetImage() %>" alt=""></td>
               <td><p><b>Type:</b> </p>
                   <p><b>Name:</b></p>
                   <p><b>Gender:</b></p>
                   <p><b>Dob:</b></p>
                   <p><b>Color:</b></p>
                   <p><b>Unit Price:</b></p>
                   <p><b>Available Qty:</b></p>
                   <p><b>Supplier Name:</b></p>
               </td>
               <td>
                   <p><%=pet.getPetType()%></p>
                   <p><%=pet.getPetName()%></p>
                   <p><%=pet.getPetGender()%></p>
                   <p><%=dob %></p>
                   <p><%=pet.getPetColor()%></p>
                   <p><%=pet.getPetprice()%></p>
                   <p><%=pet.getAvilableQty()%></p>
                   <p><%=pet.getCustomer().getFirstName()%></p>
                   <p></p>
               </td>
              
            </tr>
            </tbody>
            </table>
             
              <div id="description">
               <p><b>Description: </b><br><%=pet.getDescription()%> <p>
               <p>Quantity:<input type="number" id="quantity" max="<%=pet.getAvilableQty()%>" min="0"  name="quantity"></p>
               <p><button type="button"  onclick="addToCart()" >Add to Cart</button>
                  <button type="button" onclick="buyNow()">Buy Now</button></p>
               <p name="message" id="message"><p>
               </div>
             <tr>
    <script>
    
    
    function addToCart(){     
        let qty=document.getElementById("quantity").value;
        console.log(qty);
        if(qty>0){
        document.getElementById("message").innerHTML=" ";
    	var url="AddToCart.jsp?quantity="+qty;  
    	
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
        else{
        	document.getElementById("message").innerHTML="invalid qty";
        }
    } 
    
    function getInfo(){  
    	if(request.readyState==4){  
    	var val=request.responseText;
    	   document.getElementById("message").innerHTML=val;  
    	}  
    	}  
    
    
    // buy Now
    function buyNow(){  
    	console.log("called but"); 
        let qty=document.getElementById("quantity").value;
        console.log(qty);
        if(qty>0){
        document.getElementById("message").innerHTML=" ";
    	var url="BuyNow.jsp?quantity="+qty;  
    	if(window.XMLHttpRequest){  
    		request=new XMLHttpRequest();  
    		}  
    		else if(window.ActiveXObject){  
    		request=new ActiveXObject("Microsoft.XMLHTTP");  
    		}  
    	try  
    	{  
    	request.onreadystatechange=getInfoBuy;  
    	request.open("GET",url,true);  
    	request.send();  
    	}  
    	catch(e)  
    	{  
    	alert("Unable to connect to server");  
    	}
        }
        else{
        	document.getElementById("message").innerHTML="invalid qty";
        }
    } 
    
    function getInfoBuy(){  
    	if(request.readyState==4){  
    	var val=request.responseText;
    	   document.getElementById("message").innerHTML=val;  
    	}  
    	}  
    
    </script>         
            
</body>
</html>