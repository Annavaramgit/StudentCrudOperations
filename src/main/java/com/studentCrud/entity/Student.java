package com.studentCrud.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	@Min(100)
	@Max(600)
	
	int studentHallTicket;
	@NotBlank(message = "student name is must")
	String stuentName;
	@NotEmpty(message = "collegeName is mandatory")
	
	String collegeName;
	@NotBlank(message = "state is must")
	String state;
	List<String> skills;
	@NotBlank(message = "gender is must")
	String gender;

}
