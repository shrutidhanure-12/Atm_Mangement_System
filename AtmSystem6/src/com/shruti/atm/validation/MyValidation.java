package com.shruti.atm.validation;

public class MyValidation {

	public static Boolean checkCardNo(String cardNo) {
		return cardNo.matches("\\d{16}");
	}

	public static Boolean checkPinNo(String pinNo,String pin)
	{	
		if(pinNo.matches("\\d{4}")&&pinNo.equals(pin))
			return true;
		else
			return false;
	}
	
	public static Boolean checkChoice(String choice) {
		if(choice.matches("^(?i)(yes)$"))
			return true;
		else
			return false ;
	}
	public static Boolean checkChoice2(String choice) {
		if(choice.matches("^(?i)(yes)$"))
			return false;
		else
			return true ;
	}

}