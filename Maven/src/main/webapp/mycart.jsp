<%@page import="java.util.ArrayList"%>
<%@page import="java.util.*"%>
<%@page import="com.petshop.daoimpl.*"%>
<%@page import="com.petshop.model.*"%>
<%@page import="com.petshop.model.CartItems"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Cart</title>
<link rel="stylesheet" href="MyCart.css">
</head>
<body>
	<%
	CartItemsDAO cartItemDao = new CartItemsDAO();
	Customers customerDetails = new Customers();
	customerDetails = (Customers) session.getAttribute("customer");
	List<CartItems> cartList = new ArrayList<CartItems>();
	cartList = cartItemDao.showMyCart(customerDetails);
    PetDetails pet =new PetDetails();
    PetDAO petDao=new PetDAO();
	session.setAttribute("cartList", cartList);
	%>

	<div class="head">
		<div class="navigation">
			<h1>PET Shop</h1>
			<ul id="menu">
				<li><a href="myprofile.jsp">My Profile</a></li>
				<li><a href="mycart.jsp">My cart</a></li>
				<li><a href="myorders.jsp">My orders</a></li>
				<li><a href="AddItem.jsp">Add item</a></li>
				<li><a href="home.jsp">Home</a></li>
			</ul>
		</div>
	</div>
	<table>
		<%
		double totalAmount = 0;
		for (CartItems cartItems : cartList) {
			totalAmount += cartItems.getTotalPrice();
			pet=petDao.showPet(cartItems.getPet().getPetId());
		%>
		<tr>
			<td><img src="<%=cartItems.getPet().getPetImage()%> alt="petimage"></td>

			<td><p >
					Item id:<span id="itemid"><%=cartItems.getItemId()%></span></p>
				<p>
					Pet id:<%=cartItems.getPet().getPetId()%></p>
				<p>
					Pet Type:<%=cartItems.getPet().getPetType()%></p>
				<p>
					Pet Name:<%=cartItems.getPet().getPetName()%></p>
				<p >
					Quantity:<span id="quantity"><%=cartItems.getQuantity()%></span></p>
				<p>
					Unit_price:<%=cartItems.getUnitPrice()%></p>
				<p>

					Total price:<%=cartItems.getTotalPrice()%></p>
              
				<p>
					<a
						href="PetDescription.jsp?petid=<%=cartItems.getPet().getPetId()%>"><button id="view">View</button></a>
				       <button type="button" id="buynow" onclick="buy('<%=cartItems.getItemId()%>')">BuyNow</button>
				      <a href="Remove?itemId=<%=cartItems.getItemId()%>"><button type="button" id="remove">Remove</button></a>
				      <%String message="message"+cartItems.getItemId(); %>
				      <p name="message" id="<%=message%>"><p>
				</p></td>

		</tr>
		<%
		}
		session.setAttribute("totalCartAmount", totalAmount);
		%>
	</table>
	<%if(cartList.size()>0){ %>
	<button id="buyall" onclick="buyAll()">Buyall</button>
	<a href="RemoveAll"><button id="removeall">Remove All</button></a>
	<p name="messageall" id="messageall"><p>
	 <%} else{%>
	 <h1 id="empty">Your cart is empty</h1>
	  <%} %>
	<script type="text/javascript">
	//buy all
     function buyAll(){  
     	console.log("called");
     	var url="BuyAll.jsp";  
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
     	document.getElementById('messageall').innerHTML=val;  
     	}  
     	}  
     
     //buy
     function buy(itemId){  
      	console.log("called buy");
      	console.log(itemId);
      	var url="CartBuy.jsp?itemId="+itemId;  
      	console.log(url);
      	if(window.XMLHttpRequest){  
      		request=new XMLHttpRequest();  
      		}  
      		else if(window.ActiveXObject){  
      		request=new ActiveXObject("Microsoft.XMLHTTP");  
      		}  
      	try  
      	{  
      	request.onreadystatechange=getInfobuy;  
      	request.open("GET",url,true);  
      	request.send();  
      	}  
      	catch(e)  
      	{  
      	alert("Unable to connect to server");  
      	}  
      	}  
      
      function getInfobuy(){  
      	if(request.readyState==4){  
      	var val=request.responseText;  
      	var message='message'+itemId;
      	document.getElementById(message).innerHTML=val;  
      	}  
      	}  

     </script>
</body>
</html>