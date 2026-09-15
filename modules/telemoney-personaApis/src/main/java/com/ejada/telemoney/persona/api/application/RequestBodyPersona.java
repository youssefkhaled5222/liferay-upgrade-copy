package com.ejada.telemoney.persona.api.application;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestBodyPersona {
	@JsonProperty("nationality")
	String nationality;
	
	@JsonProperty("age")
	int age;
	
	@JsonProperty("customer Segment")
	String customerSegment;
	
	@JsonProperty("income")
	int income;
	
	@JsonProperty("sector")
	String sector;
	
	@JsonProperty("gender")
	String gender;

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCustomerSegment() {
		return customerSegment;
	}

	public void setCustomerSegment(String customerSegment) {
		this.customerSegment = customerSegment;
	}

	public int getIncom() {
		return income;
	}

	public void setIncom(int incom) {
		this.income = incom;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}
