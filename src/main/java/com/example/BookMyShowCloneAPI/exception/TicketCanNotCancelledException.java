package com.example.BookMyShowCloneAPI.exception;

public class TicketCanNotCancelledException extends RuntimeException {
private String msg;

public TicketCanNotCancelledException(String msg) {
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
