package com.shruti.atm.dao;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.shruti.atm.entity.Card;
import com.shruti.atm.presentation.LoginApp;

public class CardDaoImpl implements CardDao{

	private EntityManager entityManager;
	private EntityTransaction entityTransaction;
	private Card card;
	

	public CardDaoImpl() {
		entityManager=MyConnection.getEntityManagerObject();
		entityTransaction=entityManager.getTransaction();
		
	}

	
	@Override
	public Card findCardNumber(String cardNo) {
		card=entityManager.find(Card.class, cardNo);
		return card;
	}

	
	@Override
	public String updateCardStatus(Card card) {
		Card card1=findCardNumber(card.getCardNo());
		if(card1!=null) {
			
			card1.setCardStatus("De-Active");
			entityTransaction.begin();
			entityManager.persist(card1);
			entityTransaction.commit();
			return "updated";
		}else 
		{
			return "not updated";
		}
	}

	@Override
	public String updatePinNo(String cardNo,String newPinNo) {
		card=LoginApp.getLoginDetails();
			card.setCardNo(cardNo);
			card.setPinNo(newPinNo);
			entityTransaction.begin();
			entityManager.persist(card);
			entityTransaction.commit();
		return "Update pin";
	}


	

	
	}

	
	
	

