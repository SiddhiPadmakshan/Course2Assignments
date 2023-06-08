package com.simpli;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String rememberMe = request.getParameter("rememberMe");
		
		if(userName.equals("Siddhi Padmakshan") && password.equals("Siddhi@1234")) {
			RequestDispatcher rd = request.getRequestDispatcher("DashboardServlet");
			rd.forward(request, response);
		}
		else {
			if(userName.equals("Siddhi Padmakshan")) {
				out.println("Error: Password is incorrect. Please try again!");
			}
			 else if(password.equals("Siddhi@1234")) {
				out.println("Error: Username is incorrect. Please try again!");
			} 
			 else {
			out.println("Error: The Username and Password is incorrect. Please try again!");
			 }
		}
	}

}
