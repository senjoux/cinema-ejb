package entities;

import entities.User;
import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Gerant
 *
 */
@Entity
@PrimaryKeyJoinColumn(referencedColumnName="userID",name="managerID")
public class Manager extends User implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy="manager")
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
