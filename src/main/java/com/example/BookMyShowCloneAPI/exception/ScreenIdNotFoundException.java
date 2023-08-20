package com.example.BookMyShowCloneAPI.exception;

public class ScreenIdNotFoundException extends RuntimeException {

	private String msg;

	public ScreenIdNotFoundException(String msg) {
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
