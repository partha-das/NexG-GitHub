package com.hibernet.practice;

import java.util.List;

public class Employee {

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Ceritificate> getCertificates() {
		return certificates;
	}
	public void setCertificates(List<Ceritificate> certificates) {
		this.certificates = certificates;
	}
	public Integer id;
	public String firstName,lastName;
	private List<Ceritificate> certificates;
	
	
	
	
}
