package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Student;
import com.lti.exception.NoStudentFoundException;
import com.lti.service.StudentService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class StudentController {
	@Autowired
	private StudentService sService;
	
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		return sService.listOfStudents();
	}
	
	@GetMapping("/students/{rollno}")
	public Student getById(@PathVariable("rollno")int rollno) throws NoStudentFoundException{
		return sService.findStudentById(rollno);
	}
	
	@PostMapping("/students")
	public Student addStudent(@RequestBody Student s) {
		return sService.createStudent(s);
	}
	
	@PutMapping("/students/{rollno}")
	public Student modifyStudent(@PathVariable("rollno")int rollno, @RequestBody Student s) throws NoStudentFoundException {
		return sService.updateStudentById(rollno, s);
	}
	
	@DeleteMapping("/students/{rollno}")
	public Student deleteStudent(@PathVariable("rollno")int rollno) throws NoStudentFoundException {
		return sService.deleteStudentById(rollno);
	}
}
