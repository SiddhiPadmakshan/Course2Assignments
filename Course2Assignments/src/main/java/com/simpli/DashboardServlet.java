package com.simpli;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String rememberMe = request.getParameter("rememberMe");
		response.setContentType("text/html");
		
		if(rememberMe == null) {
			rememberMe = "off";
		}
		
		out.println("<center><h2>Hi " + userName +"!!" + " Welcome to the Dashboard</h2></center><br>");
		
		out.println("Here are some predetermined details about you:<br>Age: 22, "
				+ "<br>Gender: Male, <br>Qualification: BMS <br> Your Remember me Button is: " + rememberMe+"<br><br>");
		
		out.println("Do let us know if any changes are to be made.<br>"
				+ "If not then you can log out by clicking on logout.<br>");
		
		out.println("<html><body>");
		out.println("<right><a href='login.html'>"
				+ "<p style=\"position: absolute; right: 25px; top: 5px;\">Log out</p>"
				+ "</a></right>");
		out.println("</body></html>");
	}

}
