package com.shruti.atm.dao;
import com.shruti.atm.entity.Card;

public interface CardDao {
	
	Card findCardNumber(String cardNo);
	String updateCardStatus(Card card);	
	String updatePinNo( String cardNo,String newPinNo);

	
}
