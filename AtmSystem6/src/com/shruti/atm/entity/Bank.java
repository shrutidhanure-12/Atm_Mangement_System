package com.shruti.atm.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Bank {
	@Id
	@Column(length = 11)
	private String ifscCode;
	@Column(length = 10)
	private String branchCode;
	@Column(length = 30)
	private String branchName;
	@Column(length = 30)
	private String bankAddress;

	@OneToMany(mappedBy = "bank", cascade = CascadeType.ALL)
	private List<Customer> customer;

	public String getIfscCode() {
		return ifscCode;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public String getBranchName() {
		return branchName;
	}

	public String getBankAddress() {
		return bankAddress;
	}

	public List<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}

	public Bank() {
		super();

	}

	public Bank(String ifscCode, String branchCode, String branchName, String bankAddress) {
		super();
		this.ifscCode = ifscCode;
		this.branchCode = branchCode;
		this.branchName = branchName;
		this.bankAddress = bankAddress;
	}

}
