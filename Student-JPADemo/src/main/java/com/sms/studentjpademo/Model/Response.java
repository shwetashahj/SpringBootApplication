package com.sms.studentjpademo.Model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class Response<T>{
  
	 boolean success;
	 
	 String message;
	 private T data;
	 
	public boolean isSuccess() {
		return success;
	}



	public void setSuccess(boolean success) {
		this.success = success;
	}



	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public void setData(T data) {
		this.data = data;
	}



	
	
	
	 
	 public T getData() {
	      return data;
	   }

	
}
