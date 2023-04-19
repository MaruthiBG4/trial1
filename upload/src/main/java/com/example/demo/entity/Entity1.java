package com.example.demo.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table (name="employ9")
public class Entity1 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	 @Column(name="first_Name")  
	 private String firstName;
	
	 @Column(name="last_Name")
	 private String lastName;
	
	 @Column(name="email")
	  private String email;
	 
	 @Column(name="age")
	 private int age;
	 
	 @Column(name="phno")
	 private String phno;
	 
	 @Column(name="user_Name")
	 private String userName;

	 @Column(name="flag")
	 private boolean flag = Boolean.FALSE;

	 @Column(name="response_Json")
	 private String details;
	 
	 @Column(name="created_date")
	 private Date createdDate;
	 
	 @Column(name="created_by")
	 private String createdBY;
	 
	 @Column(name="updated_by")
	 private String updatedBY;
	 
	 @Column(name="updated_date")
	 private Date updatedDate;
	
	public String getCreatedBY() {
		return createdBY;
	}

	public void setCreatedBY(String createdBY) {
		this.createdBY = createdBY;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
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

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getUpdatedBY() {
		return updatedBY;
	}

	public void setUpdatedBY(String updatedBY) {
		this.updatedBY = updatedBY;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	
	
	
	 

}
