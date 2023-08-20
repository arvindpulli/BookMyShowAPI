package com.example.BookMyShowCloneAPI.exception;

public class TicketIdNotFoundException extends RuntimeException {

	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public TicketIdNotFoundException(String msg) {
		super();
		this.msg = msg;
	}
}
