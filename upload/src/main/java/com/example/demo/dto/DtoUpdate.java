package com.example.demo.dto;


public class DtoUpdate 
{
	 private int id; 
	 private String firstName;
	 private String lastName;
	 private String email;
	 private int age;
	 private String phno;
	 private String userName;
	 
	DtoUpdate dtoupdate;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public DtoUpdate getDtoupdate() {
		return dtoupdate;
	}

	public void setDtoupdate(DtoUpdate dtoupdate) {
		this.dtoupdate = dtoupdate;
	}


}
