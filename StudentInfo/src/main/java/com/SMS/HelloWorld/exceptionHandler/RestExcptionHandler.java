package com.SMS.HelloWorld.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import com.SMS.HelloWorld.Model.Response;
import com.SMS.HelloWorld.exception.BadRequestException;
import com.SMS.HelloWorld.exception.DataNotFoundException;

@ControllerAdvice

public class RestExcptionHandler {
	
	 @ExceptionHandler(DataNotFoundException.class)
	 @ResponseStatus(value = HttpStatus.NOT_FOUND)
	 @ResponseBody
	    public final Response<Void> handleDatanNotFoundException(Exception ex, WebRequest request) {

		      Response<Void> response = new Response<Void>();
		      
		      response.setSuccess(false);
		
		      response.setMessage(ex.getMessage());
		      
		      return response;
	    }
	 
	 
	 @ExceptionHandler(BadRequestException.class)
	 @ResponseStatus(value = HttpStatus.BAD_REQUEST)
	 @ResponseBody
	    public final Response<Void> handleBadRequestException(Exception ex, WebRequest request) {

		      Response<Void> response = new Response<Void>();
		      
		      response.setSuccess(false);
		
		      response.setMessage(ex.getMessage());
		      
		      return response;
	    }
	 
}


