package com.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.text.AbstractDocument.BranchElement;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		PrintWriter out = response.getWriter();

		// User input
		String email = request.getParameter("user_email");
		String user_password = request.getParameter("user_pass");

		// Debug: Print input parameters
		System.out.println("Email: " + email);
		System.out.println("Password: " + user_password);

		// JDBC Connection
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			String url = "jdbc:mysql://localhost:3306/register_login_project";
			String name = "root";
			String pass = "0716";
			Connection con = DriverManager.getConnection(url, name, pass);
			String query = "SELECT password FROM user_data WHERE email = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();

			// Check if ResultSet has results
			if (rs.next()) {
				System.out.println("Email found in database");

				String newpass = rs.getString("password");

				if (newpass.equals(user_password)) {
					RequestDispatcher rd = request.getRequestDispatcher("/Welcome.jsp");
					rd.forward(request, response);

				} else {
					out.print("<h1>Incorect Password</h1> <br>");
					
					RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
					rd.include(request, response);
					
					
				}
			} else {

				out.print("<h1>Error Email not found. SignUp as a New User</h1>");
				
				RequestDispatcher rd = request.getRequestDispatcher("/Home.jsp");
				rd.include(request, response);
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
