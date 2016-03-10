package entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: MovieTheater
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class MovieTheater implements Serializable {

	   
	@Id
	@Column(name="theaterID")
	private Integer id;
	private String name;
	private String adresse;
	private Long capacity;
	@ManyToOne
	@JoinColumn(name="FK_Manager")
	private Manager manager;
	
	@OneToMany(mappedBy="movieTheater")
	private List<Session> sessions;
	
	private static final long serialVersionUID = 1L;

	public MovieTheater() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}   
	public Long getCapacity() {
		return this.capacity;
	}

	public void setCapacity(Long capacity) {
		this.capacity = capacity;
	}
   
}
