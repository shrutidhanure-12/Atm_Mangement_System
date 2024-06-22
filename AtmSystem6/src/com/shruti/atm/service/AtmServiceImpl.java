package com.shruti.atm.service;
import java.time.LocalDate;
import java.time.LocalTime;

import com.shruti.atm.dao.AccountDao;
import com.shruti.atm.dao.AccountDaoImpl;
import com.shruti.atm.dao.CardDao;
import com.shruti.atm.dao.CardDaoImpl;
import com.shruti.atm.entity.Account;
import com.shruti.atm.entity.Card;

public class AtmServiceImpl implements AtmService{
	
	private Card card;
		CardDao cardDao=new CardDaoImpl();
		AccountDao accountDao=new AccountDaoImpl();
		@Override
		public Card findCardNumber(String cardNo) {
			card=cardDao.findCardNumber(cardNo);
			if(card!=null)
			return card ;
			else
				return null;
		}

		@Override
		public String updateCardStatus(Card card) {
			return  cardDao.updateCardStatus(card);

		}

		@Override
		public String updateBalance(String accountNo, Integer changeAccountBalance) {
			
			return accountDao.updateBalance(accountNo, changeAccountBalance);
		}

		@Override
		public String updatePinNo(String cardNo, String newPinNo) {
			
			return cardDao.updatePinNo(cardNo,newPinNo);
		}

		@Override
		public String addTransaction(String transactionId, String transactionType, Integer amount,
				LocalDate transactionDate, LocalTime transactionTime, Account account) {
		
			return accountDao.addTransaction(transactionId, transactionType, amount, transactionDate, transactionTime, account);
		}

	

}
