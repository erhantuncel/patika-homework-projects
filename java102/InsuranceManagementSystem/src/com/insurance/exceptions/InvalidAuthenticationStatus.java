package com.insurance.exceptions;

public class InvalidAuthenticationStatus extends Exception {
	
	public InvalidAuthenticationStatus(String errorMessage) {
		super(errorMessage);
	}
}
