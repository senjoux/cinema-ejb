package com.tn.cinema.services;

import java.util.List;

import javax.ejb.Local;

import com.tn.cinema.entities.Movie;

@Local
public interface MovieServiceLocal {

	boolean addMovie(Movie m);
	Movie findMovieByID(Integer id);
	boolean updateMovie(Movie m);
	boolean deleteMovie(Movie m);
	List<Movie> findAllMovies();
}
