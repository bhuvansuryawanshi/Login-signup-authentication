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
import java.sql.SQLException;


public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fname = request.getParameter("first_name");
		String lname = request.getParameter("last_name");
		String email = request.getParameter("user_email");
		String password = request.getParameter("user_pass");
		

		// JDBC Connection
		
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }
        
        try {
            String url = "jdbc:mysql://localhost:3306/register_login_project";
            String name = "root";
            String pass = "0716";
            Connection con = DriverManager.getConnection(url, name, pass);
            String query = "INSERT INTO user_data(fname, lname, email, password) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, fname);
            ps.setString(2, lname);
            ps.setString(3, email);
            ps.setString(4, password);
            
            int row_affected = ps.executeUpdate();
            
            RequestDispatcher rd = request.getRequestDispatcher("/Welcome.jsp");
            rd.forward(request, response);
            

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("<h1>ERROR</h1>");
        }
		
		
	}

}
