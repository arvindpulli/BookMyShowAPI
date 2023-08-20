package com.example.BookMyShowCloneAPI.exception;

public class MovieShowIdNotFoundException extends RuntimeException {

	private String msg;

	public MovieShowIdNotFoundException(String msg) {
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
