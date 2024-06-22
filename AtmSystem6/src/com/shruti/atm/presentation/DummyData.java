
package com.shruti.atm.presentation;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.shruti.atm.dao.CardDao;
import com.shruti.atm.dao.CardDaoImpl;
import com.shruti.atm.entity.Account;
import com.shruti.atm.entity.Bank;
import com.shruti.atm.entity.Card;
import com.shruti.atm.entity.Customer;
import com.shruti.atm.entity.Transaction;

public class DummyData {

	public static void main(String[] args) 
	{
			EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("atm");
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			
			Bank bank=new Bank("BARB0LATURX","LATURX","Bank of Badoda","Latur");
			Bank bank1=new Bank("SBIN0070264","000295","State Bank of Hyderabad","Shrigonda");
			Bank bank2=new Bank("KKBK0002030","002030","Kotak Mahindra Bank","Chalisgaon");
			
			Customer customer1=new Customer("101","Shubhada Deshmukh","Madavgan","7887481134","shubhadad.28@gmail.com","943416983067","HHLPD4056C",LocalDate.of(2000, 8, 2),bank1);
			Customer customer2=new Customer("102","Diksha Tambe","Pachora","7756860516","dikshatambe296@gmail.com","321382169360","GHTHL3056K",LocalDate.of(2001, 6, 29),bank1);
			Customer customer3=new Customer("103","Shruti Dhanure","Latur","9284362864"," shrutidhanure00@gmail.com","614604018774","HHAPD0021A",LocalDate.of(2002, 3, 12),bank2);
			Customer customer4=new Customer("104","Pranjal Barse","Chalisgaon","8788762552"," pranjalbarse2003@gmail.com","676865216112","FSHPB8885A",LocalDate.of(2003, 1, 1),bank);
			Customer customer5=new Customer("105","Dnyaneshwari Kulkarni","Latur","8261089943"," dkulkarni1602@gmail.com","291475414858","KGSPK3352K",LocalDate.of(2001, 5, 1),bank2);
			Customer customer6=new Customer("106","Aakansha Raul","Satara","9405349574","aakanksharaul00@gmail.com","607586341300","GHYYI0078K",LocalDate.of(2002, 3, 16),bank);
			Customer customer7=new Customer("108","DikshaTambe","Pachora","7756860516"," dktambe12@gmail.com","321382169360","GHTHL3056K",LocalDate.of(2001, 6, 29),bank);

			List<Customer> cust=List.of(customer1,customer2,customer3,customer4,customer5,customer6,customer7);
			
			bank.setCustomer(cust);
			bank1.setCustomer(cust);
			bank2.setCustomer(cust);
			
			Account account1=new Account("0073420000884298","Saving",40000,"Active",LocalDate.now(),customer1);
			Account account2=new Account("0642104000077604","Saving",50000,"Active",LocalDate.now(),customer2);
			Account account3=new Account("60317370272","Saving",30000,"Active",LocalDate.now(),customer3);
			Account account4=new Account("09540500003365","Saving",90000,"Active",LocalDate.now(),customer4);
			Account account5=new Account("09908100007647","Current",40000,"Active",LocalDate.now(),customer2);
			Account account6=new Account("60568709856","Saving",60000,"Active",LocalDate.now(),customer6);
			Account account7=new Account("85697436900789","Current",90000,"Deactive",LocalDate.now(),customer1);

			List<Account> acc=List.of(account1,account2,account3,account4,account5,account6,account7);
			
			customer1.setAccount(acc);
			customer2.setAccount(acc);
			customer3.setAccount(acc);
			customer4.setAccount(acc);
			customer5.setAccount(acc);
			customer6.setAccount(acc);
			customer7.setAccount(acc);
			
			Card card1=new Card("1526069943166786","Debit","8149","646","Active",LocalDate.of(2024,02,28),LocalDate.of(2026, 11, 11),account1);
			Card card2=new Card("7648562356299557","ATM Card","9876","349","De-Active",LocalDate.of(2024,02,20),LocalDate.of(2025, 9, 9),account1);
			Card card3=new Card("8975436592694021","Debit","8956","714","Active",LocalDate.of(2024,01,20),LocalDate.of(2029, 7, 7),account2);
			Card card4=new Card("6249802592656776","Debit","7895","569","Active",LocalDate.of(2024,01,10),LocalDate.of(2040, 8, 8),account3);
			Card card5=new Card("7589456899056325","ATM Card","9523","225","De-Active",LocalDate.of(2024,01,20),LocalDate.of(2030, 10, 10),account4);
			Card card6=new Card("9733603910056565","Debit","8963","614","Active",LocalDate.of(2024,02,20),LocalDate.of(2034, 5, 5),account6);
			Card card7=new Card("8745896324789896","ATM Card","1258","712","Active",LocalDate.of(2024,02,28),LocalDate.of(2040, 11, 11),account7);
			Card card8=new Card("9778963257867569","ATM Card","7485","782","Active",LocalDate.of(2024,03,05),LocalDate.of(2037, 5, 5),account5);
			
			List<Card> car=List.of(card5,card1,card2,card3,card4,card6,card7,card8);
			
			account1.setCard(car);
			account2.setCard(car);
			account3.setCard(car);
			account4.setCard(car);
			account5.setCard(car);
			account6.setCard(car);
			account7.setCard(car);
			account5.setCard(car);
			
			entityTransaction.begin();
			entityManager.persist(bank);
			entityTransaction.commit();
			entityManager.close();
	
			System.out.println("Object Added");
		}
	}


