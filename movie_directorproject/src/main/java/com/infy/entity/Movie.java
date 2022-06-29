package com.infy.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	 private Integer Movie_Id;
	private String Movie_Title;
	private LocalDate Date_Released;
	private LocalTime Movie_Running_Time;
	@ManyToMany(cascade=CascadeType.ALL)
	  @JoinTable(name = "Movie_Director",
	  joinColumns=@JoinColumn(name = "Movie_Id"),
	  inverseJoinColumns = @JoinColumn(name= "Director_Id"))
	private List<Director> directors;
	public Movie() {
		
	}
	public Movie(Integer movie_Id, String movie_Title, LocalDate date_Released, LocalTime movie_Running_Time) {
		super();
		Movie_Id = movie_Id;
		Movie_Title = movie_Title;
		Date_Released = date_Released;
		Movie_Running_Time = movie_Running_Time;
	}
	
	@Override
	public String toString() {
		return "Movie [Movie_Id=" + Movie_Id + ", Movie_Title=" + Movie_Title + ", Date_Released=" + Date_Released
				+ ", Movie_Running_Time=" + Movie_Running_Time +  "]";
	}
	public Integer getMovie_Id() {
		return Movie_Id;
	}
	public void setMovie_Id(Integer movie_Id) {
		Movie_Id = movie_Id;
	}
	public String getMovie_Title() {
		return Movie_Title;
	}
	public void setMovie_Title(String movie_Title) {
		Movie_Title = movie_Title;
	}
	public LocalDate getDate_Released() {
		return Date_Released;
	}
	public void setDate_Released(LocalDate date_Released) {
		Date_Released = date_Released;
	}
	public LocalTime getMovie_Running_Time() {
		return Movie_Running_Time;
	}
	public void setMovie_Running_Time(LocalTime movie_Running_Time) {
		Movie_Running_Time = movie_Running_Time;
	}
	public List<Director> getDirectors() {
		return directors;
	}
	public void setDirectors(List<Director> directors) {
		this.directors = directors;
	}
	
}
