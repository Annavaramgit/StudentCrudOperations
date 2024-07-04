package com.studentCrud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.studentCrud.ExceptionClasses.StudentNotFoundException;
import com.studentCrud.entity.Student;
import com.studentCrud.service.StudentService;

import jakarta.validation.Valid;

@RestController
public class ControllerClass {

	@Autowired
	private StudentService studentService;

	// storing person details in database
	//@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/save")
	public ResponseEntity<Map<String, Object>> saveMethod(@RequestBody @Valid Student student) {
		Map<String, Object> mapObj = new HashMap<>();
		System.out.println("----------");

		Student student1 = studentService.saveMethod(student);
		mapObj.put("Result ", student1);
		return new ResponseEntity<Map<String, Object>>(mapObj, HttpStatus.OK);

	}

	// fetching all persons details
	@GetMapping("/getAll")
	public ResponseEntity<List<Student>> fetchingAll() {
		List<Student> students = studentService.fetchingAll();
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);

	}

	// fetching specific person details
	//@PreAuthorize("hasRole('USER')")
	@GetMapping("/getSpecific/{id}")
	public ResponseEntity<Map<String, Object>> fetchSpecific(@PathVariable int id)// throws StudentNotFoundException
	{

		Map<String, Object> mapobj = new HashMap<>();
		Student student = studentService.fetchSpecific(id);
		mapobj.put("Result", student);
		mapobj.put("Statuc Code", HttpStatus.OK.value());

		return new ResponseEntity<Map<String, Object>>(mapobj, HttpStatus.OK);
	}

	// deleting specific person details
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map<String, String>> deleteMethod(@PathVariable int id) {
		studentService.deleteMethod(id);
		Map<String, String> mapObj = new HashMap<String, String>();
		mapObj.put("Result", "Deleted Successfully Please check In DB");
		return new ResponseEntity<Map<String, String>>(mapObj, HttpStatus.OK);
	}

	// update specific person details,here we need to pass id in postman body not pass id in url
	
	@PutMapping("/update")
	public ResponseEntity<Map<String, String>> updateMethod(@RequestBody Student student) {
		System.out.println("-------------------------------------------");
		Map<String, String> mapObj = new HashMap<String, String>();
		studentService.updateMethod(student);
		mapObj.put("Result", "Updated Successfully Please check In DB");

		return new ResponseEntity<Map<String, String>>(mapObj, HttpStatus.OK);
	}

	// update specific person details,here we need to pass id in url not in postman
	// body
	@PutMapping("updateUrl/{id}")
	public ResponseEntity<Map<String, String>> updateMethodDuplicate(@PathVariable int id,
			@RequestBody Student student) {

		Map<String, String> mapObj = new HashMap<String, String>();

		Student student1 = studentService.fetchSpecific(id);
		student1.setStudentHallTicket(student.getStudentHallTicket());
		student1.setStuentName(student.getStuentName());
		student1.setCollegeName(student.getCollegeName());

		studentService.updateMethod(student1);
		mapObj.put("Result", "Updated Successfully Please check In DB");

		return new ResponseEntity<Map<String, String>>(mapObj, HttpStatus.OK);
	}

}
