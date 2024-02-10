package com.example.studentcounseling.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.studentcounseling.entity.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student,Long> { 
	

}
