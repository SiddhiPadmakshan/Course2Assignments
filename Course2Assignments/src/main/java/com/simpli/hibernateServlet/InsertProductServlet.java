package com.simpli.hibernateServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.simpli.hibernateEntities.Product;
import com.simpli.hibernateUtil.HibernateUtil;

public class InsertProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html><body>");
		String name = request.getParameter("productName");
		String price = request.getParameter("productprice");
		BigDecimal bigDecimalPrice = new BigDecimal(price);
		try {
		SessionFactory sessFac = HibernateUtil.getSessionFactory();
		//Opening a session calling this sessionFactory session
		Session session = sessFac.openSession();
		//Querying to insert all the inputs in the database
		//session.createQuery("INSERT INTO product (product_name,product_price) Values('"+name+"','"+price+"'").executeUpdate();
		java.util.Date date = new java.util.Date();
		Product product = new Product(serialVersionUID, name, bigDecimalPrice,date);
		
		product.setID(serialVersionUID);
		product.setName(name);
		product.setPrice(bigDecimalPrice);
		product.setDateAdded(date);
		
		session.getTransaction().begin();
		session.save(product);
		session.getTransaction().commit();
		out.println("<center><h2>Data added Successfully</h2></center>");
		session.close();
		
		out.println("<br><br><center><a href=\"insertProductData.html\">Click Here to go to the HOME PAGE</a></center>");
		
		}catch (Exception e) {
			out.println("Error: Data could not be added please try again.");
		}
	}

}
