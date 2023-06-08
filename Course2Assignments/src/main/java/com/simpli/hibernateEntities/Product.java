package com.simpli.hibernateEntities;

import java.math.BigDecimal;
import java.util.Date;

public class Product {
	long ID;
	String name;
	BigDecimal price;
	Date dateAdded;
	
	public Product(long iD, String name, BigDecimal price, Date dateAdded) {
		super();
		ID = iD;
		this.name = name;
		this.price = price;
		this.dateAdded = dateAdded;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}
}
