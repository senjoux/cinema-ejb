package com.tn.cinema.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.tn.cinema.entities.SessionID;

/**
 * Entity implementation class for Entity: Session
 *
 */
@Entity

public class Session implements Serializable {

	
	@EmbeddedId
	private SessionID id;
	private Long nbrSpectators;
	
	@ManyToOne
	@JoinColumn(name="movie_fk", insertable = false, updatable = false)
	private Movie movie;
	@ManyToOne
	@JoinColumn(name="theater_fk", insertable = false, updatable = false)
	private MovieTheater movieTheater;
	
	private static final long serialVersionUID = 1L;

	public Session() {}
	
	
	public Session(Long nbrSpectators, Movie movie, MovieTheater movieTheater,Long startTime,Date date) {
		this.id=new SessionID();
		this.id.setMovieID(movie.getId());
		this.id.setTheaterID(movieTheater.getId());
		this.id.setStartTime(startTime);
		this.id.setDate(date);
		this.movie=movie;
		this.movieTheater=movieTheater;
		this.nbrSpectators = nbrSpectators;
	}


	public SessionID getId() {
		return this.id;
	}

	public void setId(SessionID id) {
		this.id = id;
	}
	public Long getNbrSpectators() {
		return nbrSpectators;
	}
	public void setNbrSpectators(Long nbrSpectators) {
		this.nbrSpectators = nbrSpectators;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public MovieTheater getMovieTheater() {
		return movieTheater;
	}
	public void setMovieTheater(MovieTheater movieTheater) {
		this.movieTheater = movieTheater;
	}
   
}
