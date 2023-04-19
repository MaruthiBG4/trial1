package com.example.demo.dto;

public class ImageDto 
{
	private Long id;  
	private String name; 
	private String type;
    private byte[] empimage;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public byte[] getEmpimage() {
		return empimage;
	}
	public void setEmpimage(byte[] empimage) {
		this.empimage = empimage;
	}

}
