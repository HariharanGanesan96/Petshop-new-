package com.servlet;

import java.io.IOException;
import java.sql.SQLException;

import com.dao.AdminDao;
import com.dao.CustomerDao;
import com.petclass.Admin;
import com.petclass.Customers;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class login extends HttpServlet{	
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		String userName=req.getParameter("usernameinput");
		String passwowrd=req.getParameter("passwordinput");
		Customers customerValidation=new Customers(userName,passwowrd);
		CustomerDao customerDao=new CustomerDao();
		String firstName=customerDao.cusValidation(customerValidation);
		if (firstName != null) {
			String name = firstName.substring(1);
			// customer login
			if (firstName.charAt(0) == '1') {
				System.out.println("welcome user: " + name);
				Customers customerDetails=new Customers(userName,passwowrd);
				customerDetails = customerDao.customerDetails(userName);
				System.out.println(customerDetails);
				res.sendRedirect("home.jsp");
			}
			else {
				System.out.println("welcome Admin: " + userName);
				Admin admin;
				AdminDao adminDao=new AdminDao();

					try {
						admin = adminDao.show(userName);
						System.out.println(admin);
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				
				
				
			}				
}		else {
	              System.out.println("Invalid uesrname or password");
}
}
}