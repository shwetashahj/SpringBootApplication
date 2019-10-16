package com.SMS.HelloWorld.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;



public class DataNotFoundException extends RuntimeException {
	
	
	private static final long serialVersionUID = 1L;

	
	public DataNotFoundException(String message) {
		super(message);
	}

   
	

	

}