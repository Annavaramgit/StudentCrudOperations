package com.studentCrud.ExceptionClasses;

public class StudentNotFoundException extends RuntimeException {

	// private static final long serialVersionUID = 1L;

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public StudentNotFoundException() {
	}

	public StudentNotFoundException(String message) {
		super(message);
		this.message = message;
		System.out.println("----------------------------------------");
	}

}
