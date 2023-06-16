package com.sud.spring_validation_exception_handling.exception;

public class UserNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String msg) {
		super(msg);
	}

	public UserNotFoundException() {

	}
}
