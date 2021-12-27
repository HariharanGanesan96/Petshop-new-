package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/sq")
public class servlet2 extends HttpServlet {
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
		
		/* using request dispatcher
		String userName=(String) req.getAttribute("userName");*/
		
		/*Using URL redirecting
		 * String userName=req.getParameter("userName");
		 */
		
		HttpSession session=req.getSession();
		
        String userName=(String) session.getAttribute("userName");
		
		
		System.out.println("welcome :"+userName);
	}

}
