package com.SMS.BookLibrary.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Author {

	@JsonProperty(value = "FirstName")
	String firstName;
	
	@JsonProperty(value = "ID")
	int id;
	
	@JsonProperty(value = "IDBook")
	int idBook;
	
	@JsonProperty(value = "LastName")
	String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdBook() {
		return idBook;
	}

	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	

	
	
}
