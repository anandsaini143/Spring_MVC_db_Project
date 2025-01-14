package com.btps.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.btps.beans.User;
import com.btps.dbcon.DbConnection;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/loginform")
public class Login extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		
		String eml = req.getParameter("email");
		String pwd = req.getParameter("password");
		
		try {
			Connection con = DbConnection.getConnection();
			
			String select_sql_query = "SELECT * FROM register WHERE email=? AND password=?";
			PreparedStatement ps = con.prepareStatement(select_sql_query);
			ps.setString(1, eml);
			ps.setString(2, pwd);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				User user = new User();
				user.setName(rs.getString("name"));
				user.setFname(rs.getString("f_name"));
				user.setAge(rs.getString("age"));
				user.setMobile(rs.getString("phone"));
				user.setEmail(rs.getString("email"));
				user.setDistrict(rs.getString("district"));
				user.setAddress(rs.getString("address"));
				
				HttpSession session = req.getSession();
				session.setAttribute("sessio_user", user);
				
				RequestDispatcher rd = req.getRequestDispatcher("/profile.jsp");
				rd.forward(req, resp);
			}
			else {
				out.println("<h1 style='color:red'>Email I'd and password did not match</h1>");
				
				RequestDispatcher rd = req.getRequestDispatcher("/login.html");
				rd.include(req, resp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
