
package com.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.dao.Connectionutil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class Register extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		String firstName=req.getParameter("username");
		String LastName=req.getParameter("password");
		String gender=req.getParameter("gender");
		String userName=req.getParameter("username");
		String passweord=req.getParameter("password");
		String email=req.getParameter("email");
		long mobileNumber=Long.parseLong(req.getParameter("mobile"));	
		PrintWriter out=res.getWriter();
		
		Connectionutil obj = new Connectionutil();
		Connection con;
		try {
			con = obj.getDbConnect();
			String query = "insert into Customers(customer_firstname,customer_lastname,"
					+ "customer_username,customer_password,customer_email,customer_mobilenumber,customer_gender)\r\n"
					+ "values (?,?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1,firstName );
			pstmt.setString(2, LastName);
			pstmt.setString(3, userName);
			pstmt.setString(4, passweord);
			pstmt.setString(5, email);
			pstmt.setLong(6, mobileNumber);
			pstmt.setString(7, gender);
			int i = pstmt.executeUpdate();
			System.out.println(i + " row updated");
			res.sendRedirect("index.html");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}