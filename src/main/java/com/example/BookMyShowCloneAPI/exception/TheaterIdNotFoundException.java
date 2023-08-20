package com.example.BookMyShowCloneAPI.exception;

public class TheaterIdNotFoundException extends RuntimeException {

	private String msg;

	public TheaterIdNotFoundException(String msg) {
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
