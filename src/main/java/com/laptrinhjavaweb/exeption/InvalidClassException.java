package com.laptrinhjavaweb.exeption;

public class InvalidClassException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public InvalidClassException(String message) {
		super(message);
	}
}
