package com.yash.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler
{
	@ExceptionHandler(ListEmptyException.class)
	public ResponseEntity<Object> myHandler(ListEmptyException e)
	{
		return new ResponseEntity<Object>(e.getMessage() , HttpStatus.BAD_REQUEST);
	}
}
