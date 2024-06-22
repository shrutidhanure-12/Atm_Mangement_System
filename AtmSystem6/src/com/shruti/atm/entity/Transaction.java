package com.shruti.atm.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Transaction {
	@Id
	@Column(length = 40)
	private String transactionId;
	@Column(length = 10)
	private String transactionType;
	private Integer amount;
	private LocalDate transactionDate;
	private LocalTime transactionTime;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "account")
	private Account account;
	

	public Transaction() {
		super();
		
	}
	public Transaction(String transactionId, String transactionType, Integer amount, LocalDate transactionDate,
			LocalTime transactionTime, Account account) {
		super();
		this.transactionId = transactionId;
		this.transactionType = transactionType;
		this.amount = amount;
		this.transactionDate = transactionDate;
		this.transactionTime = transactionTime;
		this.account = account;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public LocalDate getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}
	public LocalTime getTransactionTime() {
		return transactionTime;
	}
	public void setTransactionTime(LocalTime transactionTime) {
		this.transactionTime = transactionTime;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
}
