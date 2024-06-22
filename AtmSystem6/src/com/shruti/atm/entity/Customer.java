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
@Entity
public class Customer {
	
	@Id 
	@Column(length = 10)
	private String customerId;
	@Column(length = 30)
	private String customerName;
	@Column(length = 30)
	private String customerAddress;
	@Column(length = 10)
	private String phoneNo;
	@Column(length = 30)
	private String email;
	@Column(length = 12)
	private String aadharCard;
	@Column(length = 10)
	private String panCard;
	private LocalDate dateOfBirth;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ifscCode")
	private Bank bank;

	public Customer(String customerId, String customerName, String cutomerAddress, String phoneNo, String email,
			String aadharCard, String panCard, LocalDate dateOfBirth, Bank bank) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAddress = cutomerAddress;
		this.phoneNo = phoneNo;
		this.email = email;
		this.aadharCard = aadharCard;
		this.panCard = panCard;
		this.dateOfBirth = dateOfBirth;
		this.bank = bank;
	}

	public Customer() {
		super();
		
	}

	@OneToMany(mappedBy = "customer" ,cascade = CascadeType.ALL)
		private List<Account> account;

	public List<Account> getAccount() {
		return account;
	}

	public void setAccount(List<Account> account) {
		this.account = account;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCutomerAddress() {
		return customerAddress;
	}

	public void setCutomerAddress(String cutomerAddress) {
		this.customerAddress = cutomerAddress;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAadharCard() {
		return aadharCard;
	}

	public void setAadharCard(String aadharCard) {
		this.aadharCard = aadharCard;
	}

	public String getPanCard() {
		return panCard;
	}

	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}
	

}
