package com.infy.dto;

import java.time.LocalDate;
import java.time.LocalTime;


import com.infy.entity.Movie;

public class MovieDTO {
	private Integer Movie_Id;
	private String Movie_Title;
	private LocalDate Date_Released;
	private LocalTime Movie_Running_Time;
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
	public MovieDTO(String movie_Title, LocalDate date_Released, LocalTime movie_Running_Time) {
		super();
		Movie_Title = movie_Title;
		Date_Released = date_Released;
		Movie_Running_Time = movie_Running_Time;
	}
	public static Movie convertDTOToEntity(MovieDTO dto) {
		
		Movie movie = new Movie();
		movie.setMovie_Title(dto.getMovie_Title());
		movie.setMovie_Running_Time(dto.getMovie_Running_Time());
		movie.setDate_Released(dto.getDate_Released());

		
		return movie;
	}
}
