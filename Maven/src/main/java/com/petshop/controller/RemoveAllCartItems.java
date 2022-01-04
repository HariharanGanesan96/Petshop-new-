package com.petshop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;

import com.petshop.daoimpl.AdminDAO;
import com.petshop.daoimpl.CartItemsDAO;
import com.petshop.daoimpl.CustomerDAO;
import com.petshop.model.Admin;
import com.petshop.model.CartItems;
import com.petshop.model.Customers;

@WebServlet("/RemoveAll")
public class RemoveAllCartItems extends HttpServlet{
	
      @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
         HttpSession session=req.getSession();
         Customers customerDetails=(Customers)session.getAttribute("customer");
         CartItemsDAO cartItemsDao=new CartItemsDAO();
         List<CartItems> cartList=(List<CartItems>)session.getAttribute("cartList");
      
         for(CartItems cartItems:cartList){
               cartItemsDao.delete(cartItems.getItemId());
         }
        
         PrintWriter write=resp.getWriter();
         write.print("<h1>All items are deleted</h1>");
          resp.sendRedirect("mycart.jsp");
    }
      
      @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	doGet(req, resp);
    }
}
