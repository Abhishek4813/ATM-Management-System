package com.atm.exceptions;

public class AuthorizationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public AuthorizationException(String msg) {
		super(msg);
	}

}
