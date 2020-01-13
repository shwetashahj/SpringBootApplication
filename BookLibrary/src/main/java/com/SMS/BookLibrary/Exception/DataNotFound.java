package com.SMS.BookLibrary.Exception;

public class DataNotFound extends RuntimeException{

	/**
	 * The serialVersionUID is a universal version identifier for a Serializable class. Deserialization uses 
	 * this number to ensure that a loaded class corresponds exactly to a serialized object.
	 *  If no match is found, then an InvalidClassException is thrown.
	 */
	private static final long serialVersionUID = 1L;
	
	public DataNotFound(String message) {
		
		/**
		 * Since a derived class always has the base class as a template, it is necessary to initialize 
		 * the base class as the first step in constructing the derived object. By default, if no super call 
		 * is made, Java will use a default (parameterless) constructor to create the base class. If you want a
		 *  different constructor to be used, you have to use super to pass in the parameters you want and invoke the 
		 *  correct constructor. 
		 *  In the case of custom exceptions, it is common to use super to initialize the exception's error message;
		 *   by passing the message into the base class constructor, the base class will take care of the work 
		 *   of setting the message up correctly.*/
		super(message);
	}

}
