package com.example.demo.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = Account.class)
public class Account {
	private Integer accoountNumber;
	private Float balance;

	public Account(final Integer accoountNumber, final Float balance) {
		this.accoountNumber = accoountNumber;
		this.balance = balance;
	}

	public Integer getAccoountNumber() {
		return accoountNumber;
	}

	public void setAccoountNumber(Integer accoountNumber) {
		this.accoountNumber = accoountNumber;
	}

	public Float getBalance() {
		return balance;
	}

	public void setBalance(Float balance) {
		this.balance = balance;
	}
	
	public Account() {
		
	}
}
