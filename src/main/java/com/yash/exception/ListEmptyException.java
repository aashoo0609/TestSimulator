package com.yash.exception;

public class ListEmptyException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String message;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ListEmptyException(String message)
	{ 
		this.message = message;
	}
	@Override
	public String toString() {
		return "ListEmptyException [message=" + message + "]";
	}
}
