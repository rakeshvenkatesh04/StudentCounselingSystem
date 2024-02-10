package com.example.studentcounseling.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentcounseling.entity.College;
import com.example.studentcounseling.repository.CollegeRepository;

@Service
public class CollegeService {
	
	@Autowired
	public CollegeRepository collegeRepo;
	
	public List<College> getAllColleges()
	{
		List<College> colleges = new ArrayList<>();
		collegeRepo.findAll().forEach(colleges::add);
		return colleges;
	}

	public void addCollege(College college) {
		collegeRepo.save(college);
		
	}

	public void updateCollege(Long id, College college) {
		collegeRepo.save(college);
		
	}

	public void deleteCollege(Long id) {
		collegeRepo.deleteById(id);
		
	}

}
