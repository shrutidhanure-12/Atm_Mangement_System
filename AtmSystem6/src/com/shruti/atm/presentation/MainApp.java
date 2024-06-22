package com.shruti.atm.presentation;
import java.util.Scanner;

import com.shruti.atm.entity.Account;
import com.shruti.atm.entity.Card;
import com.shruti.atm.entity.Customer;
import com.shruti.atm.validation.MyValidation;

public class MainApp {
	
	public MainApp() {
		Scanner scanner=new Scanner(System.in);
		App app=new AppImpl();
						
		System.out.print("\t\tWELCOME:"+LoginApp.getLoginDetails().getAccount().getCustomer().getCustomerName());
		System.out.print("  \tAccount No: "+  LoginApp.getLoginDetails().getAccount().getAccountNo());
		System.out.print(" \tBank:"+ LoginApp.getLoginDetails().getAccount().getCustomer().getBank().getBranchName());
		System.out.println();
		
			System.out.println("		=================================================================================");
			System.out.println(" 				<<<<<<<<<< WELCOME TO ATM SYSTEM >>>>>>>>>>");
			System.out.println("		=================================================================================");
			while(true)
			{
			System.out.println("     					* SELECT ACTION TO PERFORM *  ");
			System.out.println("		=================================================================================");

			System.out.println("				1:WITHDRAW         			4:CHECK BALANCE \n");
			System.out.println("				2:DEPOSIT         			5:PIN CHANGE\n");
			System.out.println("				3:MINI STATEMENT   			6:EXIT\n");
			
			System.out.println("			------------------------------------------------------------------");
			System.out.println("Enter your Choice :");
			Integer choice1=scanner.nextInt();
			System.out.println("");
		
			switch (choice1) {
			case 1: 
				app.withdrawBalance();				
				break;
			case 2:
				app.depositeBalance();
				break;
			case 3: 
					app.miniStatement();			
				break;
			case 4:
				app.checkBalance();	
				break;
			case 5: 
				app.pinChange();
				break;
			case 6:
				System.out.println("Thank you for visiting !!");
				System.exit(0);
				break;
				default:
					System.out.println("plz enter valid choice....");
					break;
				
			}System.out.println("Do you want to Continue[yes/No]");
			String choice2=scanner.next();
			if(MyValidation.checkChoice2(choice2))
			{
				System.out.println("Thank you for visiting");
				break;
			}
	}

}
}

