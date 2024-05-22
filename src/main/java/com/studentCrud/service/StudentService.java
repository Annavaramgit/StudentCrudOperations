package com.studentCrud.service;

import java.util.List;

import com.studentCrud.entity.Student;

public interface StudentService {
	
	public Student saveMethod(Student student);
	
	public List<Student> fetchingAll();
	
	public Student fetchSpecific(int id);
	
	public String deleteMethod(int id);
	
	public String updateMethod(Student student);

}
