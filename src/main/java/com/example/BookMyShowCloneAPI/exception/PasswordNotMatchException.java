package com.example.BookMyShowCloneAPI.exception;

public class PasswordNotMatchException extends RuntimeException {

	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public PasswordNotMatchException(String msg) {
		super();
		this.msg = msg;
	}
	
}
