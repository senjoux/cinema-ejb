package com.tn.cinema.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.tn.cinema.entities.User;

/**
 * Entity implementation class for Entity: Gerant
 *
 */
@Entity
@PrimaryKeyJoinColumn(referencedColumnName="userID",name="managerID")
public class Manager extends User implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy="manager",fetch=FetchType.EAGER)
	private List<MovieTheater> movieTheaters;
	
	public Manager() {
		super();
	}

	public List<MovieTheater> getMovieTheaters() {
		return movieTheaters;
	}

	public void setMovieTheaters(List<MovieTheater> movieTheaters) {
		this.movieTheaters = movieTheaters;
	}

	
   
	
}
