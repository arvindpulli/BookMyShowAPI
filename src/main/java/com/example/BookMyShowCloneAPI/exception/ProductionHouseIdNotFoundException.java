package com.example.BookMyShowCloneAPI.exception;

public class ProductionHouseIdNotFoundException extends RuntimeException {

	private String msg;

	public ProductionHouseIdNotFoundException(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}
	
	
}
