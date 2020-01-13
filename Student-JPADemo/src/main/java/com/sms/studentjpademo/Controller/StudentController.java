package com.sms.studentjpademo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sms.studentjpademo.Model.Student;
import com.sms.studentjpademo.Services.StudentServices;


public class StudentController {
	
	
	@Autowired
	StudentServices studentService;
	
	@PostMapping(value = "/addStudent")
	public String addStudent(@RequestBody Student student) {

		studentService.saveStudents(student);

		return "Successfully added the student's entry.";
	}
	
}
