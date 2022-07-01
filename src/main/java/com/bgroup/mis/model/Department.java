package com.bgroup.mis.model;

import javax.persistence.*;

@Entity
public class Department {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer did;
	@Column(name="name", nullable=false, length=250)
	private String name;
	public Department() {	
	}
	public Department(String name) {
		this.name = name;
	}
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Department [did=" + did + ", name=" + name + "]";
	}
}
