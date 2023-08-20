package com.example.BookMyShowCloneAPI.exception;

public class CustomerIdNotFoundException extends RuntimeException {

	private String msg;

	public CustomerIdNotFoundException(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
