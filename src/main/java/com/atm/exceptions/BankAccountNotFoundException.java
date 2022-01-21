package com.atm.exceptions;

public class BankAccountNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BankAccountNotFoundException(String str) {
		super(str);
	}

}
