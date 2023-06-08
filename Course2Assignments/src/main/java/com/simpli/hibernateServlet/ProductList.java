package com.simpli.hibernateServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.simpli.hibernateEntities.Product;
import com.simpli.hibernateUtil.HibernateUtil;


public class ProductList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><body>");

		SessionFactory sessFac = HibernateUtil.getSessionFactory();
		
		//Opening a session calling this sessionFactory session
		Session session = sessFac.openSession();

		// Hibernate Command to get all the products from the DB
		List<Product> productList = session.createQuery("from Product").list();

		out.println("<center><table border=1> LIST OF PRODUCTS<br><br>");
		out.println("<th>ID</th><th>Product Name</th><th>Product Price</th><th>Added Time</th>");
		for (Product prod : productList) {
			out.println("<tr><td>" + prod.getID() + "<td>" + prod.getName() + "<td>" + prod.getPrice() + "<td>"
					+ prod.getDateAdded() + "</tr>");
		}
		;
		out.println("</table>");
		out.println("<br><br><a href=\"insertProductData.html\">Click Here to go to the HOME PAGE</a></center>");
		session.close();
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}
}
