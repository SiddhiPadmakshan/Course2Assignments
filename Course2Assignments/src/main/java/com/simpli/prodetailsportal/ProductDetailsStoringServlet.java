package com.simpli.prodetailsportal;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import com.simpli.hibernateEntities.Product;

public class ProductDetailsStoringServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		try {
		HttpSession session = request.getSession();
		
		if(session == null) {
			response.sendRedirect("productDetailsPortal.html");
		}
		else {
			String productName = request.getParameter("name");
			String productPrice = request.getParameter("price");
			BigDecimal bigDecimalPrice = new BigDecimal(productPrice);
			java.util.Date date = new java.util.Date();
			
			Product newProduct = new Product();
			newProduct.setID(serialVersionUID);
			newProduct.setName(productName);
			newProduct.setPrice(bigDecimalPrice);
			newProduct.setDateAdded(date);
			session.setAttribute("newProductDetails", newProduct);
			session.setAttribute("trial", "hi");
			response.sendRedirect("productDetailsPortal.jsp");
		}
	}
	catch(Exception e) {
		out.println("Oops.. Ran into an Error. Please Try again.");
	}
	}
}
