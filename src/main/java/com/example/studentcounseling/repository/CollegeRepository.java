package com.example.studentcounseling.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.studentcounseling.entity.College;
import com.example.studentcounseling.entity.Student;

@Repository
public interface CollegeRepository extends CrudRepository<College,Long>{
	

}
