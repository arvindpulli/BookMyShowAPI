package com.example.BookMyShowCloneAPI.exception;

public class OwnerIdNotFoundException extends RuntimeException{

	private String message;

	public OwnerIdNotFoundException(String message) {
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
