package com.greatlearning.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Student_Table")
public class Student {
	
	public Student(){ 		}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "f_Name")
	private String f_Name;

	@Column(name = "l_Name")
	private String l_Name;

	@Column(name = "email")
	private String email;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "student_details_id")
	private StudentAddress studentAddressDetails;
	
	public StudentAddress getStudentAddressDetails() {
		return studentAddressDetails;
	}

	public void setStudentAddressDetails(StudentAddress studentAddressDetails) {
		this.studentAddressDetails = studentAddressDetails;
	}

	public int getId() {
		return id;
	}

	public String getF_Name() {
		return f_Name;
	}

	public void setF_Name(String f_Name) {
		this.f_Name = f_Name;
	}

	public String getL_Name() {
		return l_Name;
	}

	public void setL_Name(String l_Name) {
		this.l_Name = l_Name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Student(String f_Name, String l_Name, String email) {
		super();
		this.f_Name = f_Name;
		this.l_Name = l_Name;
		this.email = email;
	}


	
}
