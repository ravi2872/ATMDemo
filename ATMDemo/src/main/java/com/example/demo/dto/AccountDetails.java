package com.example.demo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "accountdetails")
public class AccountDetails {
	@Column(name = "accoountNumber")
	private Integer accoountNumber;
	@Column(name = "balance")
	private Float balance;

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

}
