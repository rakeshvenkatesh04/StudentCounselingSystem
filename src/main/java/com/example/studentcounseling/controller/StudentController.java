package com.example.studentcounseling.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentcounseling.entity.Student;
import com.example.studentcounseling.service.StudentService;
import com.example.studentcounseling.util.CommonUtil;

@RestController
public class StudentController extends CommonUtil {

	@Autowired
	private StudentService studentService;

	@RequestMapping(method = RequestMethod.GET, value = "/students")
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/students")
	public Object addStudent(@RequestBody Student student) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		if (handleNullCheck(student.getFirst_name()) && handleNullCheck(student.getLast_name()) 
				&& handleNullCheck(student.getEmail()) && handleNullCheck(student.getZip_code())
				&& handleNullCheck(student.getPassword()) && handleNullCheck(student.getAddress()))
				
		{
			if (student != null && (student.getZip_code().length() < 6 || student.getZip_code().length() > 6))
			{
				map.put("statusCode", "-1");
				map.put("statusMessage", "zip code must be 6 digits");
				return map;
			} 
			else if (convertLongToString(student.getMobile_number()).length() < 10
					|| convertLongToString(student.getMobile_number()).length() > 10)
			{
				map.put("statusCode", "-2");
				map.put("statusMessage", "mobile number should contain 10 digits");
				return map;
			} 
			else if (handleNullCheck(student.getPassword()) && !isPasswordFormatted(student.getPassword()))
			{
				map.put("statusCode", "-3");
				map.put("statusMessage",
						"password atlist contains one numder,letter and special charector and password length should be between 8 to 20");
				return map;
			}
			else 
			{
				map.put("statusCode", "200");
				map.put("statusMessage", "Student registered successfully");
				map.put("response", studentService.addStudent(student));
				return map;
			}
		} 
		else 
		{
			map.put("statusCode", "-4");
			map.put("statusMessage", "Enter Mandetory fields");
			map.put("required fields to register user", "First name*, Last Name*, Email*, Password*, Mobile*, Address*, Zip-code*");
			return map;
		}

		// return "string";
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/students/{id}")
	public void updateStudent(@PathVariable Long id, @RequestBody Student student) {
		studentService.updateStudent(id, student);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/students/{id}")
	public void deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
	}

}
