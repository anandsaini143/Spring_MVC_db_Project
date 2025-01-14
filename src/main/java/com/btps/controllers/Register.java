package com.btps.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.btps.dbcon.DbConnection;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/regForm")
public class Register extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");

		String name1 = req.getParameter("name");
		String fname = req.getParameter("father_name");
		String ag = req.getParameter("age");
		String fn = req.getParameter("phone");
		String eml = req.getParameter("email");
		String dist = req.getParameter("district");
		String addr = req.getParameter("address");
		String pwd = req.getParameter("password");

		try {
			Connection con = DbConnection.getConnection();

			String inser_sql_query = "INSERT INTO register VALUES(?,?,?,?,?,?,?,?)";

			PreparedStatement ps = con.prepareStatement(inser_sql_query);

			ps.setString(1, name1);
			ps.setString(2, fname);
			ps.setString(3, ag);
			ps.setString(4, fn);
			ps.setString(5, eml);
			ps.setString(6, dist);
			ps.setString(7, addr);
			ps.setString(8, pwd);

			int count = ps.executeUpdate();
			if (count > 0) {
				out.println("<h1 style='color:green'>Registered Successfully</h1>");

				RequestDispatcher rd = req.getRequestDispatcher("/login.html");
				rd.include(req, resp);
			} else {
				out.println("<h1 style='color:red'>User not registered due to some error</h1>");

				RequestDispatcher rd = req.getRequestDispatcher("/register.html");
				rd.include(req, resp);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
