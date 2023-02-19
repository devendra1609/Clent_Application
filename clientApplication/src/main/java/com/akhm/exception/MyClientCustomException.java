package com.akhm.exception;

public class MyClientCustomException extends RuntimeException{
	public MyClientCustomException(String message) {
		super(message);
	}
}
