package com.sms.studentjpademo.Services;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.studentjpademo.Model.Response;
import com.sms.studentjpademo.Model.Student;
import com.sms.studentjpademo.repo.StudentRepository;


@Service
public class StudentServices {

	@Autowired
	StudentRepository studentRespository;
	
	
	public Response<Void> saveStudents(Student s){
		
	
		Response<Void> res = new Response<Void>();
		
		studentRespository.save(s); 
		
		res.setMessage("Successfull");
		res.setSuccess(true);
		
		return res;
		
	}
	
	
	
	
	
	
	
}

