package com.tn.cinema.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

import com.tn.cinema.entities.MovieTheater;

/**
 * Entity implementation class for Entity: _3DMovieTheater
 *
 */
@Entity
public class _3DMovieTheater extends MovieTheater implements Serializable {

	private String projectionType;
	private static final long serialVersionUID = 1L;

	public _3DMovieTheater() {
		super();
	}   
	public String getProjectionType() {
		return this.projectionType;
	}

	public void setProjectionType(String projectionType) {
		this.projectionType = projectionType;
	}
   
}
