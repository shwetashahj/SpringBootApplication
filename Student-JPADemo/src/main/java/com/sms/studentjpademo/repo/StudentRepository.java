package com.sms.studentjpademo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sms.studentjpademo.Model.Student;
 
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
 
}
