package com.shruti.atm.dao;
import java.time.LocalDate;
import java.time.LocalTime;
import com.shruti.atm.entity.Account;

public interface AccountDao {
	
	String updateBalance(String accountNo,Integer changeAccountBalance);
	String addTransaction(String transactionId, String transactionType, Integer amount, LocalDate transactionDate,
	LocalTime transactionTime, Account account);

}
