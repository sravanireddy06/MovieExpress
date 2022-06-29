
package com.infy.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dto.DirectoryDTO;
import com.infy.dto.MovieDTO;
import com.infy.entity.Director;
import com.infy.entity.Movie;
import com.infy.repository.DirectorRepository;
import com.infy.repository.MovieRepository;
@Service("Movieservice")
@Transactional
public class MovieService implements MovieImpl{
DirectorRepository direpo;
MovieRepository movrepo;
@Autowired
public void setMovieRepo(MovieRepository movrepo,DirectorRepository direpo) {
	this.movrepo=movrepo;
	this.direpo=direpo;
}
@Override
public void add(MovieDTO dto,List<DirectoryDTO> directorList) {
    try {
    	System.out.println("insert executed");
    	Optional<Movie> moviecheck = movrepo.findByMovie_Title (dto.getMovie_Title());
    	if(!moviecheck.isEmpty()) {
    		throw new Exception("movie already existed");
    	}
    	Movie movie = MovieDTO.convertDTOToEntity(dto);
    	List<Director> directors = (List<Director>) directorList.stream().map(d->{
    		Director directorinmap = DirectoryDTO.convertDTOToEntity(d);
    		return directorinmap;
    	}).collect(Collectors.toList());
    	System.out.println("directors through map"+directors);
    	movie.setDirectors(directors);
    	movrepo.save(movie);
    	System.out.println("inserted successfully"+movie);
    }
    catch(Exception e) {
	System.out.println(e.getMessage());
}
}
    public void addMovies(List<MovieDTO> dto,List<DirectoryDTO> directorList) {
        try {
        	System.out.println("insert executed");
        	List<Movie> movies = (List<Movie>) dto.stream().map(d->{
        		Movie movieinmap = MovieDTO.convertDTOToEntity(d);
        		return movieinmap;
        	}).collect(Collectors.toList());
        	List<Director> directors = (List<Director>) directorList.stream().map(d->{
        		Director directorinmap = DirectoryDTO.convertDTOToEntity(d);
        		return directorinmap;
        	}).collect(Collectors.toList());
        	System.out.println("directors through map"+directors);
        	((Movie) movies).setDirectors(directors);
        	((Director) directors).setMovies(movies);
        	movrepo.saveAll(movies);
        	direpo.saveAll(directors);
        	System.out.println("inserted successfully"+movies);
        }
        catch(Exception e) {
    	System.out.println(e.getMessage());
    }
}
    @Override
	public void searchMovieByTitle(String title) {
			System.out.println("searching for the movie"+title);
			try {

				Optional<Movie> movielist = movrepo.findByMovie_Title(title);
				if (movielist.isEmpty()) {
					throw new Exception("Invalid Movie Title");
				}
				movielist.stream().forEach(System.out::println);

			} catch (Exception e) {

				System.out.println(e.getMessage());
			}
		}
	public void searchMovieByDirectorname(String first_name) {
		// TODO Auto-generated method stub
		try {
		Optional<Director> direcheck = direpo.findByFirst_Name(first_name);
    	if(!direcheck.isEmpty()) {
    		throw new Exception("director not found");
    	}
    	direcheck.stream().forEach(System.out::println);
		
	}
		catch(Exception e) {
		System.out.println(e.getMessage());
	}
	}
	@Override
	public void getDirectorListFromTitle(String title) {
		try {
			Optional<Movie> movie = movrepo.findByMovie_Title(title);
		    if(movie.isEmpty()) {
		    	throw new Exception("Movie doesn't exists");
		    }
			System.out.println("directorlist for the movie :"+title);
		    movie.get().getDirectors().stream().forEach(System.out::println);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	@Override
	public List<Movie> displayAll() {
		System.out.println("displaying all the movies details");
		try {
			List<Movie> movieList = movrepo.findAll().stream().collect(Collectors.toList());
			if (movieList.isEmpty()) {
			throw new Exception("Movie with given Title not available");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		//return movieList;

		//movieRepo.findAll().stream().forEach(System.out::println);
		//System.out.println("displaying all the movies");
		return movrepo.findAll();
	}
	@Override
	public void updateReleaseDate(LocalDate releaseDate, String movieTitle) {
		System.out.println("updating the details in database");
		try {
			Optional<Movie> movieList = movrepo.findByMovie_Title(movieTitle);
			if (movieList.isEmpty()) {
				throw new Exception("Invalid Movie Title");
			}
			Integer affected = movrepo.updateReleaseDate(releaseDate, movieTitle);
			System.out.println("total Rows updated " + affected);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	@Override
	public void deleteBasedOnMovieTitle(String Title) {
		try {
			Optional<Movie> movieList = movrepo.findByMovie_Title(Title);
			if (movieList.isEmpty()) {
				throw new Exception("Movie with given Title not available");
			}
			movrepo.deleteByMovie_Title(Title);
			System.out.println("Deleted movie with title " + Title);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	
}
