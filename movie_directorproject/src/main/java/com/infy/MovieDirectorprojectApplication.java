package com.infy;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.infy.dto.DirectoryDTO;
import com.infy.dto.MovieDTO;
import com.infy.entity.Movie;
import com.infy.service.MovieService;


@SpringBootApplication
public class MovieDirectorprojectApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=(ApplicationContext)SpringApplication.run(MovieDirectorprojectApplication.class, args);
		MovieService service =(MovieService)ctx.getBean("Movieservice");
        List<MovieDTO> dto = Arrays.asList(new MovieDTO("ABC",LocalDate.now(),LocalTime.now()));
		List<DirectoryDTO> directorList = Arrays.asList(new DirectoryDTO("hello", "hii", "pondichery","greeting@gmailcom",97654432));
		MovieDTO dtos = new MovieDTO("XYZ",LocalDate.now(),LocalTime.now());
		//1.ading data to the database
		//1.adding one movie for many directors
		service.add(dtos,directorList);
		//2.adding many movies to many directors
		service.addMovies(dto, directorList);
		
		//2.searching the data in the database
		//1.searching movie based on title
		
	    String Title = "BNC";
		service.searchMovieByTitle(Title);
		//2.searching based on director name
		service.searchMovieByDirectorname("simple");
		//3.list directory details based on movie title
	   service.getDirectorListFromTitle("ABC");
	    //Display all the movies
	   service.displayAll();
	    //Update new release date based on the movie title
	   service.updateReleaseDate(LocalDate.of(2022, 4, 12), "ABC");
	    //Remove movie based on movie title
	    service.deleteBasedOnMovieTitle("BNC");
	    
	}

}
