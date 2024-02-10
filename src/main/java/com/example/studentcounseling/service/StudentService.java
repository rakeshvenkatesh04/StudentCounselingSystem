package com.example.studentcounseling.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentcounseling.entity.Student;
import com.example.studentcounseling.repository.StudentRepository;
//import com.example.studentcounseling.util.PasswordGenerator;

@Service
public class StudentService {
	
	@Autowired
	public StudentRepository studentRepo;
	
	public List<Student> getAllStudents()
	{
		List<Student> students = new ArrayList<>();
		studentRepo.findAll().forEach(students::add);
		return students;
	}

	public Student addStudent(Student student) {
		System.out.println(student.getFirst_name());
		Student s=studentRepo.save(student);
		return s;
		
	}
	/*public String generateAndSetRandomPassword(User user) {
        // Generate a random password of length 8 characters
        String randomPassword = PasswordGenerator.generateRandomPassword(8);

        // Assuming your User class has a setPassword() method
        user.setPassword(randomPassword);

        // Optionally, you can save the user with the new password in the database
        // userRepository.save(user);

        return randomPassword;
    }*/

	public void updateStudent(Long id, Student student) {
		studentRepo.save(student);
		
	}

	public void deleteStudent(Long id) {
		studentRepo.deleteById(id);
		
	}

}
