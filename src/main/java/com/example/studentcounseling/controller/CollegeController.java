package com.example.studentcounseling.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentcounseling.entity.College;
import com.example.studentcounseling.service.CollegeService;

@RestController
public class CollegeController {
	
	@Autowired
	private CollegeService collegeService;
	
	@RequestMapping(method = RequestMethod.GET, value="/colleges")
	public List<College> getAllColleges()
	{
		return collegeService.getAllColleges();
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/colleges")
	public void addCollege(@RequestBody College college)
	{
		collegeService.addCollege(college);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/colleges/{id}")
	public void updateCollege(@PathVariable Long id, @RequestBody College college)
	{
		collegeService.updateCollege(id, college);
	}
	
	
	@RequestMapping(method = RequestMethod.DELETE, value="/colleges/{id}")
	public void deleteCollege(@PathVariable Long id)
	{
		collegeService.deleteCollege(id);
	}

}
