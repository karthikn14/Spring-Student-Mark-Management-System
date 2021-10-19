package com.karthi.springboot.Service;

import java.util.List;

import com.karthi.springboot.model.Student;

public interface StudentService {
	List<Student> getAllStudents();
	void saveStudent(Student student);
	Student getStudentById(long regNo);
	void deleteStudentById(long regNo);

}
