package com.shruti.atm.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Card {

	@Id
	@Column(length = 16)
	private String cardNo;
	@Column(length = 10)
	private String cardType;
	@Column(length = 4)
	private String pinNo;
	@Column(length = 3)
	private String cardCvv;
	@Column(length = 10)
	private String cardStatus;
	private LocalDate issuedDate;
	private LocalDate expiryDate;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "account")
	private Account account;
	public Card(String cardNo, String cardType, String pinNo, String cardCvv, String cardStatus, LocalDate issuedDate,LocalDate expiryDate,
			Account account) {
		super();
		this.cardNo = cardNo;
		this.cardType = cardType;
		this.pinNo = pinNo;
		this.cardCvv = cardCvv;
		this.cardStatus = cardStatus;
		this.issuedDate=issuedDate;
		this.expiryDate = expiryDate;
		this.account = account;
	}

	public Card() {

	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getPinNo() {
		return pinNo;
	}

	public void setPinNo(String pinNo) {
		this.pinNo = pinNo;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardCvv() {
		return cardCvv;
	}

	public void setCardCvv(String cardCvv) {
		this.cardCvv = cardCvv;
	}

	public String getCardStatus() {
		return cardStatus;
	}

	public void setCardStatus(String cardStatus) {
		this.cardStatus = cardStatus;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getCardNo() {
		return cardNo;
	}
	public LocalDate getIssuedDate() {
		return issuedDate;
	}
	public void setIssuedDate(LocalDate issuedDate) {
		this.issuedDate = issuedDate;
	}

}
