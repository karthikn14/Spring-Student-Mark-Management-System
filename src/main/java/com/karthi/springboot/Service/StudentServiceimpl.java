package com.karthi.springboot.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karthi.springboot.Repository.StudentRepository;
import com.karthi.springboot.model.Student;

@Service
public class StudentServiceimpl implements StudentService {
	@Autowired
	private StudentRepository studentrepository;

	@Override
	public List<Student> getAllStudents() {
		return studentrepository.findAll();		
		
	}

	@Override
	public void saveStudent(Student student) {
		student.setTotal(student.getMark1()+student.getMark2()+student.getMark3());
		student.setAverage(student.getTotal()/3);
		this.studentrepository.save(student);
	}

	@Override
	public Student getStudentById(long regNo) {
        Optional < Student > optional = studentrepository.findById(regNo);
        Student student = null;
        if (optional.isPresent()) {
        	student = optional.get();
        } else {
            throw new RuntimeException(" student not found for regno :: " + regNo);
        }
        return student;

	}

	@Override
	public void deleteStudentById(long regNo) {
		this.studentrepository.deleteById(regNo);
	}

}
