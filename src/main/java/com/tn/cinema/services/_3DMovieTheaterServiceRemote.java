package com.tn.cinema.services;

import java.util.List;

import javax.ejb.Remote;

import com.tn.cinema.entities.Manager;
import com.tn.cinema.entities._3DMovieTheater;

@Remote
public interface _3DMovieTheaterServiceRemote {

	boolean add_3DMovieTheater(_3DMovieTheater mt);
	_3DMovieTheater find_3DMovieTheaterByID(Integer id);
	boolean update_3DMovieTheater(_3DMovieTheater mt);
	boolean delete_3DMovieTheater(_3DMovieTheater mt);
	List<_3DMovieTheater> getAll_3DMovieTheaters();
	List<_3DMovieTheater> get_3DMovieTheatersByManager(Manager m);
	List<_3DMovieTheater> get_3DMovieTheaterByAddressLike(String address);
}
