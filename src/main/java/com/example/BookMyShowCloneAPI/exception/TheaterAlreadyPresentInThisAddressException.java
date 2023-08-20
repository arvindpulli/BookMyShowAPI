package com.example.BookMyShowCloneAPI.exception;

public class TheaterAlreadyPresentInThisAddressException extends RuntimeException {

	private String msg;

	public TheaterAlreadyPresentInThisAddressException(String msg) {
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
