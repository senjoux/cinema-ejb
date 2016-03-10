package entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Movie
 *
 */
@Entity

public class Movie implements Serializable {

	   
	@Id
	@Column(name="movieID")
	private Integer id;
	private String title;
	private Long length;
	private String type;
	@OneToMany(mappedBy="movie")
	private List<Session> sessions;
	
	private static final long serialVersionUID = 1L;

	public Movie() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}   
	public Long getLength() {
		return this.length;
	}

	public void setLength(Long length) {
		this.length = length;
	}   
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}
   
}
