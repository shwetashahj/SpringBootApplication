package com.SMS.HelloWorld.Services;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.stereotype.Service;

import com.SMS.HelloWorld.Model.Response;
import com.SMS.HelloWorld.Model.Student;
import com.SMS.HelloWorld.exception.BadRequestException;
import com.SMS.HelloWorld.exception.DataNotFoundException;

@Service
public class StudentServices {

	ArrayList<Student> listOfStudent = new ArrayList<>();

	public StudentServices() {
		for (int i = 0; i < 3; i++) {

			Student student = new Student();
			student.setAge(25);
			student.setCity("Charlotte");
			student.setName("Shweta");
			student.setId(i);

			listOfStudent.add(student);
		}
	}

	public Response<ArrayList<Student>> getAllList() {
		throw new BadRequestException("Bad request");
		
		
		
//		Response<ArrayList<Student>> response = new Response<>();
//		response.setData(listOfStudent);
//		response.setMessage("");
//		response.setSuccess(true);
//		
//		return response;
	}

	public void addStudent(Student student) {

		listOfStudent.add(student);

	}

	public void delete(int id) {

		// Student student = new Student();
		Iterator<Student> iterator = listOfStudent.iterator();

		while (iterator.hasNext()) {
			Student student = iterator.next();

			if (student.getId() == id) {
				iterator.remove();
			}

		}

	}

	public void update(int id, Student studnet) {

		// Student student = new Student();
		Iterator<Student> iterator = listOfStudent.iterator();

		//if(id == null) {
			
		//}
		while (iterator.hasNext()) {
			Student s = iterator.next();
			if (s.getId() == id) {
				iterator.remove();
				listOfStudent.add(studnet);
				
			}

		}

	}
	
	
	public Response<Student> getById(int id) {
		
		
		Response<Student> response = new Response<>();
		for(int i = 0; i < listOfStudent.size() ; i++) {
			
			if(listOfStudent.get(i).getId() == id) {
				
				response.setData(listOfStudent.get(i));
				response.setMessage("");
				response.setSuccess(true);
				
				
				return response;
				
			}
			
		}
		
		 throw new DataNotFoundException("Not Found") ;
	}
}

