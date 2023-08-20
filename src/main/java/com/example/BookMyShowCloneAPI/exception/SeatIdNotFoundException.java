package com.example.BookMyShowCloneAPI.exception;

public class SeatIdNotFoundException extends RuntimeException {
private String msg;

public SeatIdNotFoundException(String msg) {
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
