
package com.example.Student_CURD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Student_CURD.model.Student;
import com.example.Student_CURD.service.StudentService;

@Controller
@RequestMapping("/web")
public class StudentWebController {

	@Autowired
	private StudentService service;
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("students", service.getStudents());
		return "index";
	}
	
	
	@GetMapping("/add")
	public String addStudentPage(Model model) {
		model.addAttribute("student",new Student());
		return "add-student";
	}
	
	@PostMapping("/save")
	public String saveStudent(@ModelAttribute Student student) {
		service.saveStudent(student);
		return "redirect:/web/";
	}
	
	@GetMapping("/edit/{id}")
	public String editStudent(@PathVariable Long id,Model model) {
		model.addAttribute("student",service.getStudentById(id));
		return "edit-student";
	}
	
	@PostMapping("/update/{id}")
	public String updateStudent(@PathVariable Long id,@ModelAttribute Student student) {
		service.updateStudent(id, student);
		return "redirect:/web/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable Long id) {
		service.deleteStudent(id);
		return "redirect:/web/";
	}
}
