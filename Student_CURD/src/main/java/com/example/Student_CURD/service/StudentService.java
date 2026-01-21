package com.example.Student_CURD.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.Student_CURD.model.Student;
import com.example.Student_CURD.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository repository;
	
	
	//CREATE
	public Student saveStudent(Student student) {
		return repository.save(student);
		
	}
	
	//READ
	public List<Student> getStudents(){
		return repository.findAll();	
	}
	
	public Student getStudentById(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	//DELETE
	public String deleteStudent(Long id) {
		repository.deleteById(id);
		return "Student Removed!!" + id;
	}
	
	
	//UPDATE
	public Student updateStudent( Long id,Student student) {
		Student exist=repository.findById(id).orElseThrow(()-> new RuntimeException("Student Not Found"));
		if (student == null ||
		        (student.getName() == null && student.getEmail() == null && student.getAge() == 0)) {

		        return exist; // shows data for editing
		    }
		exist.setName(student.getName());
		exist.setEmail(student.getEmail());
		exist.setAge(student.getAge());
		
		return repository.save(exist);
	}
	
}
