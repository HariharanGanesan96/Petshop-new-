<%@page import="java.io.PrintWriter"%>
<%@page import="com.petshop.daoimpl.CartItemsDAO"%>
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
<title>Add to cart</title>
</head>
<body>

<%  
    boolean available=true;

    PrintWriter out1=response.getWriter();
    CartItemsDAO cartItemDao=new CartItemsDAO();
    
    Customers customerDetails=(Customers)session.getAttribute("customer");
    
    PetDetails pet=(PetDetails)session.getAttribute("pet");
    
    List<CartItems> cartList=new ArrayList<CartItems>();
    
    cartList=cartItemDao.showMyCart(customerDetails);
    
    PrintWriter write=response.getWriter();
    
    for(CartItems cartitems:cartList){
    	if(cartitems.getPet().getPetId()==pet.getPetId()){
    		
    		available=false;
    		write.print("This item already in cart");
    		
    		break;
    	}
    }
    
   if(available){
    int quantity=Integer.parseInt(request.getParameter("quantity"));  
    
    CartItems cart=new CartItems();
    
    cart.getPet().setPetId(pet.getPetId());
    cart.getCustomer().setCustomerId(customerDetails.getCustomerId());
    cart.setQuantity(quantity);
    cart.setUnitPrice(pet.getPetprice());
    cart.setTotalPrice(quantity*pet.getPetprice());
    
    
    CartItemsDAO cartItemsDao=new CartItemsDAO();
    cartItemsDao.insert(cart);
    write.print("item add to cart");
   }
    %>

</body>
</html>