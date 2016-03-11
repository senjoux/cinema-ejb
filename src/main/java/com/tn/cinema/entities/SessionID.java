package com.tn.cinema.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: SessionID
 *
 */
@Embeddable
public class SessionID implements Serializable {

	private Long startTime;
	private Date date;
	
	@Column(name = "movie_fk")
	private int movieID;
	@Column(name = "theater_fk")
	private int theaterID;
	
	private static final long serialVersionUID = 1L;

	public SessionID() {
		super();
	}

	public Long getStartTime() {
		return startTime;
	}

	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}
	
	
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getMovieID() {
		return movieID;
	}

	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}

	public int getTheaterID() {
		return theaterID;
	}

	public void setTheaterID(int theaterID) {
		this.theaterID = theaterID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + movieID;
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
		result = prime * result + theaterID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SessionID other = (SessionID) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (movieID != other.movieID)
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		if (theaterID != other.theaterID)
			return false;
		return true;
	}


   
}
