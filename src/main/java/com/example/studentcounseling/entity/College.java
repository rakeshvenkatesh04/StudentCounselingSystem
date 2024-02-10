package com.example.studentcounseling.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "College")
public class College {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true)
	private long college_id;
	private String college_name;
	private String college_address;
	
	
	public College() {
	}

	public College(long college_id, String college_name, String college_address) {
		super();
		this.college_id = college_id;
		this.college_name = college_name;
		this.college_address = college_address;
	}

	public long getCollege_id() {
		return college_id;
	}

	public void setCollege_id(long college_id) {
		this.college_id = college_id;
	}

	public String getCollege_name() {
		return college_name;
	}

	public void setCollege_name(String college_name) {
		this.college_name = college_name;
	}

	public String getCollege_address() {
		return college_address;
	}

	public void setCollege_address(String college_address) {
		this.college_address = college_address;
	}
		
}
