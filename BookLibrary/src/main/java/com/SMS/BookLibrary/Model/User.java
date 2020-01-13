package com.SMS.BookLibrary.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {


	@JsonProperty(value = "ID")
	int id;
	@JsonProperty(value = "UserName")
	String userName;
	@JsonProperty(value = "Password")
	String password;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
