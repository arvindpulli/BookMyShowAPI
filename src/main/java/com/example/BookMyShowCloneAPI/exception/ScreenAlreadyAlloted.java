package com.example.BookMyShowCloneAPI.exception;

public class ScreenAlreadyAlloted extends RuntimeException {

	private String msg;

	public ScreenAlreadyAlloted(String msg) {
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
