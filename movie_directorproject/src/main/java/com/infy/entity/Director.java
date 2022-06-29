package com.infy.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Director {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer Director_Id;
	@Column(name="first_name")
	private String First_Name;
	@Column(name="Last_Name")
	private String last_Name;
	private String Address;
	private String Email;
	@Column(name="Contact_Number")
	private Integer Contactnumber;
	@ManyToMany(mappedBy="directors")
	private List<Movie> movies;
	public Director() {
		
	}
	public Director(Integer director_Id, String first_Name, String last_Name, String Address, String Email,
			Integer Contactnumber) {
		super();
		this.Director_Id = director_Id;
		this.First_Name = first_Name;
		this.last_Name = last_Name;
		this.Address = Address;
		this.Email = Email;
		this.Contactnumber = Contactnumber;
	}
	@Override
	public String toString() {
		return "Director [Director_Id=" + Director_Id + ", firstName=" + First_Name + ", lastName=" + last_Name
				+ ", Address=" + Address + ", Email=" + Email + ", Contactnumber=" + Contactnumber + "]";
	}
	public Integer getDirector_Id() {
		return Director_Id;
	}
	public void setDirector_Id(Integer director_Id) {
		Director_Id = director_Id;
	}
	public String getFirstName() {
		return First_Name;
	}
	public void setFirstName(String first_Name) {
		this.First_Name = first_Name;
	}
	public String getLastName() {
		return last_Name;
	}
	public void setLastName(String last_Name) {
		this.last_Name = last_Name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public Integer getContactnumber() {
		return Contactnumber;
	}
	public void setContactnumber(Integer contactnumber) {
		Contactnumber = contactnumber;
	}
	public List<Movie> getMovies() {
		return movies;
	}
	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	
}
