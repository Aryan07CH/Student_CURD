package com.example.Student_CURD.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Student_CURD.model.Student;
import com.example.Student_CURD.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService service;
	
	//Post: CREATE
	@PostMapping("/add")
	public Student addStudent(@RequestBody Student student) {
		return service.saveStudent(student);
	}
	
	//GET
	@GetMapping("/all")
	public List<Student> findAllStudent(){
		return service.getStudents();
	}
	
	@GetMapping("/{id}")
	public Student findOneStudent(@PathVariable Long id){
		return service.getStudentById(id);
	}
	
	//PUT
	@PutMapping("/update/{id}")
	public Student updateOrFetch(@PathVariable Long id, @RequestBody(required = false) Student student) {
	    return service.updateStudent(id, student);
	}



	
	
	//DELETE
	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable Long id) {
		return service.deleteStudent(id);
	}
}