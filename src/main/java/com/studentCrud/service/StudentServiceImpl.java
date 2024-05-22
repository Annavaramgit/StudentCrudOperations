package com.studentCrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.studentCrud.ExceptionClasses.ProvideValidDetailsExceptionClass;
import com.studentCrud.ExceptionClasses.StudentNotFoundException;
import com.studentCrud.entity.Student;
import com.studentCrud.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student saveMethod(Student student) {
		
		return studentRepository.save(student);
	}

	@Override
	public List<Student> fetchingAll() {
		
		List<Student> studentsList = studentRepository.findAll();
		
		return studentsList;
	}

	@Override
	public Student fetchSpecific(int id){
		
		
		//Student student= studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found for this id :: " + id));
		Student student	= studentRepository.findById(id).orElseThrow(()-> new StudentNotFoundException("No Student Found At::"+id+" Please Check Once Agin"));
	return student;
	}

	@Override
	public String deleteMethod(int id) {
		
		
		if( studentRepository.findById(id).isEmpty()) 
			throw new StudentNotFoundException("No Student Found At::"+id+" Please Check Once Agin");
			
		
		studentRepository.deleteById(id);
	
		return "Deleted Successfully";
	}

	@Override
	public String updateMethod(Student student) {
	
		if(student.getStudentHallTicket()<100||student.getStuentName().isEmpty()||student.getCollegeName().isEmpty())
			throw new ProvideValidDetailsExceptionClass("give valid details , please check once again..");
		
		
		if( studentRepository.findById(student.getId()).isEmpty()) 
			throw new StudentNotFoundException("No Student Found At::"+student.getId()+" Please Check Once Agin");
		
		studentRepository.save(student);
		
		return "Updated..";
	}

}
