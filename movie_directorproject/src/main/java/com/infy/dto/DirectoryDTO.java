package com.infy.dto;

import com.infy.entity.Director;

public class DirectoryDTO {
	private Integer Director_Id;
	private String first_Name;
	private String last_Name;
	private String Email;
	private String Address;
	private Integer Contactnumber;
	public Integer getDirector_Id() {
		return Director_Id;
	}
	public void setDirector_Id(Integer director_Id) {
		Director_Id = director_Id;
	}
	public String getFirst_Name() {
		return first_Name;
	}
	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}
	public String getLast_Name() {
		return last_Name;
	}
	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public Integer getContactnumber() {
		return Contactnumber;
	}
	public void setContactnumber(Integer contactnumber) {
		Contactnumber = contactnumber;
	}
	public DirectoryDTO(String first_Name, String last_Name, String email, String address, Integer contactnumber) {
		super();
		this.first_Name = first_Name;
		this.last_Name = last_Name;
		Email = email;
		Address = address;
		Contactnumber = contactnumber;
	}
	public static Director convertDTOToEntity(DirectoryDTO dto) {
		  Director director  = new Director();
		  
		  director.setAddress(dto.getAddress());
		  director.setLastName(dto.getLast_Name());
		  director.setContactnumber(dto.getContactnumber());
		  director.setEmail(dto.getEmail());
		  director.setFirstName(dto.getFirst_Name());
		  return director;
		  
	}
	}
