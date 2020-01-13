package com.sms.studentjpademo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "student")
public class Student {
	
	@Id
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "age", length = 500)
	private int age;
	 
	@Column(name = "city", length = 500)
	private String city;
	
	
	
	
	
	
}
