package com.SMS.BookLibrary.ExceptionHandlers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import com.SMS.BookLibrary.Exception.BadRequest;
import com.SMS.BookLibrary.Exception.DataNotFound;
import com.SMS.BookLibrary.Exception.UnAuthorizedException;
import com.SMS.BookLibrary.Model.Reponse;

@ControllerAdvice
public class RestExceptionHandler {
	
	
	
	@ExceptionHandler(DataNotFound.class)
	 @ResponseStatus(value = HttpStatus.NOT_FOUND)
	 @ResponseBody
	    public final Reponse<Void> handleDatanNotFoundException(Exception ex) {

		      Reponse<Void> response = new Reponse<Void>();
		      
		      response.setSuccess(false);
		
		      response.setMessage(ex.getMessage());
		      
		      return response;
	    }
	 
	 
	 @ExceptionHandler(BadRequest.class)
	 @ResponseStatus(value = HttpStatus.BAD_REQUEST)
	 @ResponseBody
	    public  Reponse<Void> handleBadRequestException(Exception ex) {

		      Reponse<Void> response = new Reponse<>();
		      
		      response.setSuccess(false);
		
		      response.setMessage(ex.getMessage());
		      
		      return response;
	    }
	 
	 @ExceptionHandler(UnAuthorizedException.class)
	 @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
	 @ResponseBody
	    public  Reponse<Void> handleUnAuthorisedException(Exception ex) {

		      Reponse<Void> response = new Reponse<>();
		      
		      response.setSuccess(false);
		
		      response.setMessage(ex.getMessage());
		      
		      return response;
	    }
	 
	 @ExceptionHandler(MissingServletRequestParameterException.class)
	 @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
	 public Reponse<Void> handleMissingParams(MissingServletRequestParameterException ex) {
		 
		 Reponse<Void> response = new Reponse<>();
	      
	      response.setSuccess(false);
	
	      response.setMessage(ex.getMessage());
	      
	      return response;
//	     String name = ex.getParameterName();
//	     System.out.println(name + " parameter is missing");
	     // Actual exception handling
	 }
}
