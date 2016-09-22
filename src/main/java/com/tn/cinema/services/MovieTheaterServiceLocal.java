package com.tn.cinema.services;

import java.util.List;

import javax.ejb.Local;

import com.tn.cinema.entities.Manager;
import com.tn.cinema.entities.MovieTheater;

@Local
public interface MovieTheaterServiceLocal {

	boolean addMovieTheater(MovieTheater mt);
	MovieTheater findMovieTheaterByID(Integer id);
	boolean updateMovieTheater(MovieTheater mt);
	boolean deleteMovieTheater(MovieTheater mt);
	List<MovieTheater> getAllMovieTheaters();
	List<MovieTheater> getMovieTheatersByManager(Manager m);
	List<MovieTheater> getMovieTheatersByAddressLike(String address);
	List<MovieTheater> getMovieTheatersByManagerID(Integer managerID);
}
