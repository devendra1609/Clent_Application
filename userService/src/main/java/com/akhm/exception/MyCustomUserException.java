package com.akhm.exception;

public class MyCustomUserException extends RuntimeException{
	public MyCustomUserException(String message) {
		super(message);
	}
}
