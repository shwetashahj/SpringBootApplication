package com.SMS.BookLibrary.Model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;



/*
 * @JsonInclude
Is used at serialization time only. It says that if value of a property (or all properties) in question is 
equal to certain value (null, empty - whatever that means, or a default value) this property is not serialized.
Without this annotation property value is always serialized. The annotation helps to reduce number of 
transferred properties (Property default value must be specified when it is not present on receiving side).*/

@JsonInclude(value = Include.NON_NULL)
public class Reponse<T> {

	boolean Success;
	String message;
	private T data;
	
	public boolean isSuccess() {
		return Success;
	}
	public void setSuccess(boolean success) {
		Success = success;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}

	
	
}
