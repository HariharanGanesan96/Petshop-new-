package com.petshop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.petshop.daoimpl.AdminDAO;
import com.petshop.daoimpl.CartItemsDAO;
import com.petshop.daoimpl.CustomerDAO;
import com.petshop.model.Admin;
import com.petshop.model.Customers;

@WebServlet("/Remove")
public class RemoveCartItem extends HttpServlet{
	
      @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    
    	int itemId=Integer.parseInt(req.getParameter("itemId"));		
    	CartItemsDAO cartItemsDao=new CartItemsDAO();
        cartItemsDao.delete(itemId);
        resp.sendRedirect("mycart.jsp");
     

    }
      
      @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	doGet(req, resp);
    }
}
