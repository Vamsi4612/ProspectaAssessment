package com.prospecta.exceptions;

public class NoHandlerFoundException extends Exception{
	
	public NoHandlerFoundException() {
		
	}
	public NoHandlerFoundException(String msg) {
		super(msg);
	}
}
