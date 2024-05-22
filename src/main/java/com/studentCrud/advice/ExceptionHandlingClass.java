package com.studentCrud.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.studentCrud.ExceptionClasses.ProvideValidDetailsExceptionClass;
import com.studentCrud.ExceptionClasses.StudentNotFoundException;

import jakarta.validation.UnexpectedTypeException;

@RestControllerAdvice
public class ExceptionHandlingClass {

	// this method handles StudentNotFoundException class Raised Exception and
	// provides meaningful response
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<String> NosuchExeptionMethod(StudentNotFoundException ex) {

		// ex.getMessage() it gets which message we provided in the service class it
		// brings
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> validation(MethodArgumentNotValidException er) {
		Map<String, String> map = new HashMap<>();

		er.getBindingResult().getFieldErrors().forEach(error -> {
			map.put(error.getField(), error.getDefaultMessage());
		});

		return map;
	}

	@ExceptionHandler(ProvideValidDetailsExceptionClass.class)
	public ResponseEntity<Map<String, String>> validation2(ProvideValidDetailsExceptionClass er) {

		Map<String, String> mapObj = new HashMap();
		mapObj.put("Error is:", er.getMessage());
		return new ResponseEntity<>(mapObj, HttpStatus.BAD_REQUEST);
	}

}
