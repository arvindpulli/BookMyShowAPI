package com.example.BookMyShowCloneAPI.exception;

public class TicketAlredyExpiedException extends RuntimeException {
private String msg;

public TicketAlredyExpiedException(String msg) {
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
