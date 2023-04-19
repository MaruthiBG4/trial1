package com.example.demo.dto;

import java.util.List;
import java.util.Map;


public class Response {
	private int id;
	private String firstName;
	private String lastName;
	private int age;
	private String phno;
	private String email;
	private String userName;
	
	 private String createdBY;
	 private String createdDate;
	 private String updatedBY;
	 private String updatedDate;

	 
	// private Map<String,Object> address;
	 
	 private List<Map<String,Object>>  responseJson; 

	public String getCreatedBY() {
		return createdBY;
	}

	public void setCreatedBY(String createdBY) {
		this.createdBY = createdBY;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedBY() {
		return updatedBY;
	}

	public void setUpdatedBY(String updatedBY) {
		this.updatedBY = updatedBY;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Map<String, Object>> getResponseJson() {
		return responseJson;
	}

	public void setResponseJson(List<Map<String, Object>> responseJson) {
		this.responseJson = responseJson;
	}
	
	

//	public ResponseJson getResponseJson() {
//		return responseJson;
//	}
//
//	public void setResponseJson(ResponseJson responseJson) {
//		this.responseJson = responseJson;
//	}

//	public Map<String, Object> getAddress() {
//		return address;
//	}
//
//	public void setAddress(Map<String, Object> address) {
//		this.address = address;
//	}


}
