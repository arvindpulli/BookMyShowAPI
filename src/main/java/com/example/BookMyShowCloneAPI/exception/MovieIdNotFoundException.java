package com.example.BookMyShowCloneAPI.exception;

public class MovieIdNotFoundException extends RuntimeException {

	private String message;

	public MovieIdNotFoundException(String msg) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
