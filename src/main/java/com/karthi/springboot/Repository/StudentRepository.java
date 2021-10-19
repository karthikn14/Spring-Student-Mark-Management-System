package com.karthi.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.karthi.springboot.model.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
