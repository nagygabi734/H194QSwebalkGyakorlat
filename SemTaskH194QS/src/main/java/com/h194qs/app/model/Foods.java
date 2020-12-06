package com.h194qs.app.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Foods {
	private Long id;
	private String name;
	private String type;
	private int price;
	private int amount;

	public Foods() {
	}

	

	public Foods(Long id, String name, String type, int price, int amount) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.price = price;
		this.amount = amount;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	public int getAmount() {
		return amount;
	}



	public void setAmount(int amount) {
		this.amount = amount;
	}

	
}