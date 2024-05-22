package com.studentCrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentCrud.entity.Student;

public interface StudentRepository extends  JpaRepository<Student, Integer>{

}
