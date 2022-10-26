package com.lti.service;

import java.util.List;
import com.lti.entity.Student;
import com.lti.exception.NoStudentFoundException;

public interface StudentService {
	public Student createStudent(Student s);
	public List<Student> listOfStudents();
	public Student findStudentById(int rollno) throws NoStudentFoundException;
	public Student updateStudentById(int rollno, Student s) throws NoStudentFoundException;
	public Student deleteStudentById(int rollno) throws NoStudentFoundException;
}
