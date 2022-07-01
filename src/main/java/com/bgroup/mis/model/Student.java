package com.bgroup.mis.model;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;


@Entity(name="astudent")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="fname", nullable=false,length=50)
	private String firstname;
	@Column(name="lname", nullable=false,length=50)
	private String lastname;
	@Column(name="email", nullable=false,length=100)
	private String email;
	private LocalDate dob;
	@Transient
	private int age;
	
	@ManyToOne
	@JoinColumn(name = "did" , nullable=false)
	private Department department;
	public Student() {
		
	}
	public Student(Long id, String firstname, String lastname, String email, LocalDate dob) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.dob = dob;
		}
	public Student(Long id, String firstname, String lastname, String email, LocalDate dob, int age) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.dob = dob;
		this.age = age;
	}
	public Student(String firstname, String lastname, String email, LocalDate dob) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.dob = dob;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public int getAge() {
		LocalDate today=LocalDate.now();
		int age=0;
				if(this.dob!=null) {
					age= Period.between(this.dob, today).getYears();
				}
		return age;		
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", dob=" + dob + ", age=" + age + ", department=" + department + "]";
	}
	public Department getDepartment() {
		return department;
	}
	public Student(Long id, String firstname, String lastname, String email, LocalDate dob, int age,
			Department department) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.dob = dob;
		this.age = age;
		this.department = department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
}