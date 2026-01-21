package com.example.Student_CURD.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Student_CURD.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
