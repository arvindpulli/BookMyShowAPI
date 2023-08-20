package com.example.BookMyShowCloneAPI.exception;

public class TicketAlreadyCancelledException extends RuntimeException {

	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public TicketAlreadyCancelledException(String msg) {
		super();
		this.msg = msg;
	}
	
	
}
