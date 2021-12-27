package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/home")
public class AddServlet extends HttpServlet{
		
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		
		String userName=req.getParameter("usernameinput");
		String password=req.getParameter("passwordinput");
		
		
		HttpSession session=req.getSession();
		session.setAttribute("userNme",userName);
		
	    res.sendRedirect("sq");
		
		/* URL redirecting 
		res.sendRedirect("sq?userName="+userName);*/
		
		
		// using request dispatcher we can change servlet to another servlet 
		//to do that we have redirect it
		/*req.setAttribute("userName", userName);
		RequestDispatcher rd=req.getRequestDispatcher("sq");
		rd.forward(req, res);*/
		
		
		// to print the value 
		/*PrintWriter out=res.getWriter();
		out.println("user name : "+userName);
		out.println("welcome");*/
		
	}
}
