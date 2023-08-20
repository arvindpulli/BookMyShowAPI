package com.example.BookMyShowCloneAPI.exception;

public class CustomerEmailNotFoundException extends RuntimeException {
private String msg;

public String getMsg() {
	return msg;
}

public void setMsg(String msg) {
	this.msg = msg;
}

public CustomerEmailNotFoundException(String msg) {
	super();
	this.msg = msg;
}

}
