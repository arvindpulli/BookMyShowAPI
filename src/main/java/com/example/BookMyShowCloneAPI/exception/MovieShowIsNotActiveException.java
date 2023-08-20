package com.example.BookMyShowCloneAPI.exception;

public class MovieShowIsNotActiveException extends RuntimeException {
private String msg;

public MovieShowIsNotActiveException(String msg) {
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
