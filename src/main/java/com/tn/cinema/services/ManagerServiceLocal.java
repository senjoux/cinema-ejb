package com.tn.cinema.services;

import java.util.List;

import javax.ejb.Local;

import com.tn.cinema.entities.Manager;

@Local
public interface ManagerServiceLocal {

	boolean addManager(Manager m);
	boolean updateManager(Manager m);
	boolean deleteManager(Manager m);
	List<Manager> findAllManagers();
	Manager findManagerByID(Integer id);
	Manager findManagerByEmail(String email);
	Manager findManagerByEmailAndPassword(String email,String password);
	
}
