package com.ACE9TechLab.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ACE9TechLab.demo.entity.Student;
import com.ACE9TechLab.demo.exception.StudentNotFoundException;

import jakarta.annotation.PostConstruct;


@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> students;
	
	@PostConstruct
	private void loadData() {

		students = new ArrayList<>();
		students.add(new Student("Poornima","Patel"));
		students.add(new Student("Mario","Rossi"));
		students.add(new Student("Mary","Smith"));
		
	}

	@GetMapping("/students")
	public List<Student> getStudents() {
		return students;
	}
	
	@GetMapping("/students/{studentID}")
	public Student getStudentById(@PathVariable int studentID) {
		
		if( studentID >= students.size() || studentID<0) {
			throw new StudentNotFoundException("Student ID not found: "+ studentID);
		}
		
		return students.get(studentID);
	}

	
}
