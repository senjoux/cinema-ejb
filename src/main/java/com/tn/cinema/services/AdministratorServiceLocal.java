package com.tn.cinema.services;

import java.util.List;

import javax.ejb.Local;

import com.tn.cinema.entities.Administrator;

@Local
public interface AdministratorServiceLocal {

	boolean addAdministrator(Administrator a);
	boolean updateAdministrator(Administrator a);
	boolean deleteAdministrator(Administrator a);
	List<Administrator> findAllAdministrators();
	Administrator findAdministratorByID(Integer id);
	Administrator findAdministratorByEmail(String email);
	Administrator findAdministratorByEmailAndPassword(String email,String password);
	
}
