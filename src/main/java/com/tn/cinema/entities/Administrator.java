package com.tn.cinema.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.tn.cinema.entities.User;

/**
 * Entity implementation class for Entity: Administrator
 *
 */
@Entity
@PrimaryKeyJoinColumn(referencedColumnName="userID",name="adminID")
public class Administrator extends User implements Serializable {
	
	private boolean isSuper;
	private static final long serialVersionUID = 1L;
	

	public Administrator() {
		super();
	}


	public boolean isSuper() {
		return isSuper;
	}


	public void setSuper(boolean isSuper) {
		this.isSuper = isSuper;
	}   
	
	
}
