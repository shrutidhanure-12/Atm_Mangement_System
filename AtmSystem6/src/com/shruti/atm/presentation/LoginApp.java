package com.shruti.atm.presentation;
import java.util.Scanner;
import com.google.protobuf.Service;
import com.shruti.atm.entity.Account;
import com.shruti.atm.entity.Card;
import com.shruti.atm.service.AtmService;
import com.shruti.atm.service.AtmServiceImpl;
import com.shruti.atm.validation.MyValidation;

public class LoginApp {
		static AtmService atmService = new AtmServiceImpl();
		static Account account = null;
		static Card card;
		static Boolean flagCardNo=true;
		static Boolean flagPinNo=true;
		static Scanner scanner = new Scanner(System.in);
		static Integer i = 0;
		static Integer j=0;
		static Integer  count=1;
		public static Card getLoginDetails() {
			while(flagCardNo)
			{
				System.out.println("Enter Card No:");
				String cardNo=scanner.next();
				i++;
				if(i<=3&&MyValidation.checkCardNo(cardNo))
				{
					card=atmService.findCardNumber(cardNo);
					if(card!=null)
					{
						flagCardNo =false;
						while(flagPinNo)
						{
							System.out.println("Enter The Pin No:");
							String pinNo=scanner.next();
							count++;
							if(count<=3)
							{
								if(MyValidation.checkPinNo(pinNo,card.getPinNo()))
								{
									
									new MainApp();
									flagPinNo=false;	
								}
								else
								{
									System.out.println("Enter Valid Pin No:");
									
								}
							}
							else
							{	atmService.updateCardStatus(card);
								System.out.println("you have Only 3 attempy Contact With Your Bank ");
								
								break;		
							}
						}
					}
				else
					{
						System.out.println("Card Not Found");
					}
				}
				else if (i==3)
				{
					System.out.println("Only 3 Attempts Are Allowed..");
					System.exit(0);
				}
				else
				{
					System.out.println("Enter 16 Digits Only");
				}
					
			}
			return card;
			
		}
		public static void main(String args[])
		{
			LoginApp.getLoginDetails();
			
		}
}
