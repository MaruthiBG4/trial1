package com.example.demo.dto;

public class ImageResponse 
{
	private int id ; 
	private String name; 
	private String type;
	private int empId; 
	private byte[] empimage;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public byte[] getEmpimage() {
		return empimage;
	}
	public void setEmpimage(byte[] empimage) {
		this.empimage = empimage;
	}

}
