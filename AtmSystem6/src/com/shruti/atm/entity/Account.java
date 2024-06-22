package com.shruti.atm.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Account {

	@Id
	@Column(length = 16)
	private String accountNo;
	@Column(length = 10)
	private String accountType;
	private Integer accountBalance;
	@Column(length = 10)
	private String accountStatus;
	private LocalDate openingDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="customerId")
	private Customer customer;
	
	@OneToMany(mappedBy = "account",cascade = CascadeType.ALL)
	private List<Transaction> transaction;
	
	@OneToMany(mappedBy = "account",cascade = CascadeType.ALL)
	private List<Card> card;
	
	public Account(String accountNo, String accountType, Integer accountBalance, String accountStatus,
			LocalDate openingDate, Customer customer) {
		super();
		this.accountNo = accountNo;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.accountStatus = accountStatus;
		this.openingDate = openingDate;
		this.customer = customer;
	}

	public void setCard(List<Card> card) {
		this.card = card;
	}

	public Account() {	}

	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}
	
	public String getAccountNo() 
	{
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Integer getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Integer accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public LocalDate getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(LocalDate openingDate) {
		this.openingDate = openingDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Transaction> getTransaction() {
		return transaction;
	}

	public List<Card> getCard() {
		return card;
	}	
}
