package com.tn.cinema.services;

import javax.ejb.Remote;

import com.tn.cinema.entities.User;

@Remote
public interface UsersFacadeRemote {
	public User authenticate(String email,String password);
}
