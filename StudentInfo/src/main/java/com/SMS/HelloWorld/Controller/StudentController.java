package com.SMS.HelloWorld.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.SMS.HelloWorld.Model.Student;
import com.SMS.HelloWorld.Model.Response;
//import com.SMS.HelloWorld.Services.NoDataAvailable;
import com.SMS.HelloWorld.Services.StudentServices;
import com.SMS.HelloWorld.exception.DataNotFoundException;

@RestController
@RequestMapping("/student")
public class StudentController<T> {

	@Autowired
	StudentServices studentService;

	@RequestMapping("/getAll")
	public Response<ArrayList<Student>> getAll() {
		
		
		return studentService.getAllList();
	}

	@GetMapping("{id}")
	public Response<Student> getById(@PathVariable("id") int id)throws DataNotFoundException {
		
		return studentService.getById(id);
	}
	

	@PostMapping(value = "/addStudent")
	public String addStudent(@RequestBody Student student) {

		studentService.addStudent(student);

		return "Successfully added the student's entry.";
	}
	

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public String deleteStudent(@PathVariable int id) {

		studentService.delete(id);
		return "Successfully deleted the student's entry.";
	}
	
	

	@PutMapping("/update/{id}")
	public Response<Void> updateStudent(@PathVariable int id, @RequestBody Student student) {

		studentService.update(id, student);

		Response<Void> response = new Response<>();
		response.setMessage("Successfully updated the student's entry");

		return response;
	}

}

