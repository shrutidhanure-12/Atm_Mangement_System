
package com.shruti.atm.presentation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.hibernate.internal.build.AllowSysOut;

import com.shruti.atm.entity.Account;
import com.shruti.atm.entity.Card;
import com.shruti.atm.entity.Transaction;
import com.shruti.atm.service.AtmService;
import com.shruti.atm.service.AtmServiceImpl;
import com.shruti.atm.validation.MyValidation;

public class AppImpl implements App{
	Card card;
	public	String transactionId;
	Integer amount;
	Scanner scanner=new Scanner(System.in);
	AtmService atmService=new AtmServiceImpl();
	Integer count=0;
	Boolean flagTransaction=true;
	
	@Override
	public void withdrawBalance() {
		card=LoginApp.getLoginDetails();
		try {
		if(card!=null) {
		System.out.println("Enter amount");
		amount=scanner.nextInt();
		Account account=card.getAccount();
		if(account !=null) 
		{
			Integer currentBalance=account.getAccountBalance();//MyValidation.checkAmount(amount, currentBalance
			if(currentBalance>= amount && amount>0) {
				Integer newBalance=currentBalance-amount;
				atmService.updateBalance(card.getAccount().getAccountNo(), newBalance);
				transactionId=UUID.randomUUID().toString();
				atmService.addTransaction(transactionId, "WithDraw",amount,LocalDate.now(),LocalTime.now(),card.getAccount());
				System.out.println("Transaction Succsesful..");
				System.out.println("Do you want receipt[yes/No]");
				String choice=scanner.next();
				if(MyValidation.checkChoice(choice))
				{	System.out.println("\t****Transaction Receipt****");
				System.out.println("-------------------------------------------");
					System.out.println("\tTransactionId      :" +transactionId);
					System.out.println("\tDeposited Amount   :" +amount);
					System.out.println("\tCurrent Balance is :" +newBalance);
					System.out.println("\tAccount No         :"+account.getAccountNo());
				}else {
					System.out.println("Thank you!!");
				}
				
			}else {
				System.out.println("Enter a valid amount");
			}
		}
		else{
			System.out.println("Account null");
			}
		}
		
		else {
			System.out.println("Card is null");
		}}catch(InputMismatchException e) {
			System.out.println("Enter valid amount");
		}
		}
		
	@Override
	public void depositeBalance() {
		 card=LoginApp.getLoginDetails();
		 try {
		if(card!=null) {
		System.out.println("Enter amount");
		amount=scanner.nextInt();
		Account account=card.getAccount();
		if(account !=null) {
		Integer currentBalance=account.getAccountBalance();
			if(  amount>0) {
				Integer newBalance=currentBalance+amount;
				atmService.updateBalance(card.getAccount().getAccountNo(), newBalance);
				transactionId=UUID.randomUUID().toString();
				atmService.addTransaction(transactionId, "Deposit",amount,LocalDate.now(),LocalTime.now(),card.getAccount());
				System.out.println("Transaction Succsesful..");
				System.out.println("Do you want receipt[yes/No]");
				String choice=scanner.next();
				if(choice.equalsIgnoreCase("yes"))
				{	
					System.out.println("\t****Transaction Receipt****");
					System.out.println("-------------------------------------------");
					System.out.println("\tTransactionId      :" +transactionId);
					System.out.println("\tDeposited Amount   :" +amount);
					System.out.println("\tCurrent Balance is :" +newBalance);
					System.out.println("\tAccount No         :"+account.getAccountNo());
					System.out.println();
				}else {
					System.out.println("Thank you..");
				}
		}else {
			System.out.println("Enter Valid Amount");
		}
		}else {
			System.out.println("Object is Null");
		}
		}else {
			System.out.println("Card Not Found");
		}
		}
		catch(InputMismatchException e) {
		System.out.println("Enter valid amount");
		}
	}

	@Override
	public void checkBalance() {
		card=LoginApp.getLoginDetails();
		if(card!=null) {
		System.out.println("Your Current Account Balance is: "+card.getAccount().getAccountBalance());
	}
	}

	@Override
	public void pinChange() {
		card=LoginApp.getLoginDetails();
		if(card!=null) {
			System.out.println("Enter a New pin");
			String newPin=scanner.next();
			System.out.println("Enter a confirm Pin");
			String confirmPin=scanner.next();
			if(MyValidation.checkPinNo(confirmPin,newPin)) {
				atmService.updatePinNo(card.getCardNo(),confirmPin);
				System.out.println("Pin changed Succsesfully..");
			}else {
				System.out.println("New Pin And Confirm Pin Do Not Match Or Length Is More Than 4");
			}

		}else {
			System.out.println("Card Not Found");
		}
	}

	@Override
	public void miniStatement() 
	{
		card=LoginApp.getLoginDetails();
		List<Transaction> transaction=card.getAccount().getTransaction();
		Iterator<Transaction> itr=transaction.iterator();
		System.out.println("              **Mini Statement**");
		while(itr.hasNext() && count<3)
		{
			Transaction transaction1=itr.next();
			if(transaction1!=null)
			{
				
			System.out.println(" Transaction Id    :"+transaction1.getTransactionId());
			System.out.println(" Transaction Type  :"+transaction1.getTransactionType());
			System.out.println(" Transaction Date  :"+transaction1.getTransactionDate());
			System.out.println(" Transaction Time  :"+transaction1.getTransactionTime());
			System.out.println(" Transaction Amount:"+ transaction1.getAmount());
			System.out.println(" Acccount No       :"+transaction1.getAccount().getAccountNo());
			System.out.println("-----------------------------------------------------------------    ");
			flagTransaction=false;
			}
			else 
			{
				System.out.println("No Transaction Recently");
			}
			count++;
		}
		}
	
	}

	
	
