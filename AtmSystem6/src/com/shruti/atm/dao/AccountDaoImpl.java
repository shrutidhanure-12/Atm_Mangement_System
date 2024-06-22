package com.shruti.atm.dao;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.shruti.atm.entity.Account;
import com.shruti.atm.entity.Card;
import com.shruti.atm.entity.Transaction;
import com.shruti.atm.presentation.LoginApp;

public class AccountDaoImpl implements AccountDao{
	private EntityManager entityManager;
	private EntityTransaction entityTransaction;
	private Card card;
	
	public AccountDaoImpl() 
	{
		entityManager=MyConnection.getEntityManagerObject();
		entityTransaction=entityManager.getTransaction();
		
	}
	
	
	public String updateBalance(String accountNo, Integer changeAccountBalance) {
		 card=LoginApp.getLoginDetails();
		if(card!=null) {
			card.getAccount().setAccountBalance(changeAccountBalance);
			entityTransaction.begin();
			entityManager.persist(card);
			entityTransaction.commit();
			return "anount updated";
			
		}
		return "Amount is not updated";
	}

	
	@Override
	public String addTransaction(String transactionId, String transactionType, Integer amount, LocalDate transactionDate,
			LocalTime transactionTime, Account account) 
	{
		
		Transaction transaction=new Transaction(transactionId,transactionType,amount,transactionDate,transactionTime,account);
		entityTransaction.begin();
		entityManager.persist(transaction);
		entityTransaction.commit();
		return "added";
	}

	

}
