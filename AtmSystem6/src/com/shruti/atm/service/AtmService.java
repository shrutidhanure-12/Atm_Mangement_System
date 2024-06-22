package com.shruti.atm.service;
import java.time.LocalDate;
import java.time.LocalTime;

import com.shruti.atm.entity.Account;
import com.shruti.atm.entity.Card;

public interface AtmService {
	Card findCardNumber(String cardNo);
	String updateCardStatus(Card card);
	String updateBalance(String accountNo, Integer changeAccountBalance);
	String updatePinNo(String cardNo,String newPinNo);
	String addTransaction(String transactionId, String transactionType, Integer amount, LocalDate transactionDate,
			LocalTime transactionTime, Account account);
	
}
