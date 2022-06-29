package com.infy.service;

import java.time.LocalDate;
import java.util.List;

import com.infy.dto.DirectoryDTO;
import com.infy.dto.MovieDTO;
import com.infy.entity.Movie;

public interface MovieImpl {
	void add(MovieDTO dto,List<DirectoryDTO> directorDTO);
	void addMovies(List<MovieDTO> dto,List<DirectoryDTO> directorList);
	void searchMovieByTitle(String title);
	void getDirectorListFromTitle(String title);
	void updateReleaseDate(LocalDate releaseDate, String movieTitle);
	List<Movie> displayAll();
	void deleteBasedOnMovieTitle(String Title);
}
