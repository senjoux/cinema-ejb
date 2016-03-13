package com.tn.cinema.services;

import java.util.List;

import javax.ejb.Remote;

import com.tn.cinema.entities.Movie;

@Remote
public interface MovieServiceRemote {

	boolean addMovie(Movie m);
	Movie findMovieByID(Integer id);
	boolean updateMovie(Movie m);
	boolean deleteMovie(Movie m);
	List<Movie> findAllMovies();

}
