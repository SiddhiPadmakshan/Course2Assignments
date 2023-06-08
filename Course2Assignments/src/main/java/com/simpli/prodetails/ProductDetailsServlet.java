package com.simpli.prodetails;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class ProductDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html><body>");
		
		InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties");
		Properties prop = new Properties();
		prop.load(in);
		
		String url = prop.getProperty("url");
		String userid = prop.getProperty("userid");
		String password = prop.getProperty("password");
		String id = request.getParameter("id");
		
		DBConnection dbConnection = null;
		try {
			//calling the dbconnection from dbconnection class
			dbConnection = new DBConnection(url, userid, password);
			
			//connecting to the db
			Connection connection = dbConnection.getConnection();
			
			//Creating the statement object
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			//Creating a resultset object to get the result through a query
			ResultSet resultSet = statement.executeQuery("SELECT * FROM product WHERE ID='"+id+"';");
			
			if(resultSet.next()) {
				String ID = resultSet.getString("ID");
				
				String name = resultSet.getString("product_name");
				float price = resultSet.getFloat("product_price");
				String dateAdded = resultSet.getString("date_added");
				
				// out.println(ID+ " ,"+ name+ " ,"+ price+ " ,"+ dateAdded + "<br>");
					out.println("<CENTER>PRODUCT DETAILS OF PRODUCT WITH ID "+ID + "</CENTER><hr><br>");
					out.println("<br>ID:  " + ID + "<br>NAME :  " + name + 
							"<br>PRICE:  " +price+"<br> Date Added: "+dateAdded+"<br><hr>");
					}
			else if(!resultSet.next()) {
				out.println("<CENTER>PRODUCT WITH ID "+id + " NOT FOUND!</CENTER><br>");
			}
		
		}catch (Exception e) {
			out.println("Error: Database connection Failed!");
		}
	}
}
