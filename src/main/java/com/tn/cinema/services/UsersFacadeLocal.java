package com.tn.cinema.services;

import javax.ejb.Local;

import com.tn.cinema.entities.User;

@Local
public interface UsersFacadeLocal {

	public User authenticate(String email,String password);
}
