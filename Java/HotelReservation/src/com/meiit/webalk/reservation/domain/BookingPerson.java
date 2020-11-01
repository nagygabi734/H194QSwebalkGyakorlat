package com.meiit.webalk.reservation.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BookingPerson extends User {
	
	private String name;
	private int accountNumber;
<<<<<<< HEAD
	private BigDecimal balance;
=======
	//BigDecimal
	private int balance;
>>>>>>> 1e1e5cea61bca8e9086527ebe4871191f8f316d7
	private LocalDate birth;
	private Currency currency;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal i) {
		this.balance = i;
	}
	public LocalDate getBirth() {
		return birth;
	}
	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}
	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
}
