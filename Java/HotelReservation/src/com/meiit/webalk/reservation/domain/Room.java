package com.meiit.webalk.reservation.domain;

import java.math.BigDecimal;

public class Room {

	private int number;
	private int beds;
	private boolean balcon;
<<<<<<< HEAD
	private BigDecimal price;
=======
	//BigDecimal
	private int price;
>>>>>>> 1e1e5cea61bca8e9086527ebe4871191f8f316d7
	private WingType wing;
	
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public WingType getWing() {
		return wing;
	}
	public void setWing(WingType wing) {
		this.wing = wing;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getBeds() {
		return beds;
	}
	public void setBeds(int beds) {
		this.beds = beds;
	}
	public boolean isBalcon() {
		return balcon;
	}
	public void setBalcon(boolean balcon) {
		this.balcon = balcon;
	}
	
}
