package com.tn.cinema.services;

import java.util.List;

import javax.ejb.Remote;

import com.tn.cinema.entities.Manager;

@Remote
public interface ManagerServiceRemote {

	boolean addManager(Manager m);
	boolean updateManager(Manager m);
	boolean deleteManager(Manager m);
	List<Manager> findAllManagers();
	Manager findManagerByID(Integer id);
	Manager findManagerByEmail(String email);
	Manager findManagerByEmailAndPassword(String email,String password);
}
