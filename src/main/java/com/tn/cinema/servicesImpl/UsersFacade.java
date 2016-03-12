package com.tn.cinema.servicesImpl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.tn.cinema.entities.User;
import com.tn.cinema.services.AdministratorServiceLocal;
import com.tn.cinema.services.ManagerServiceLocal;
import com.tn.cinema.services.UsersFacadeLocal;
import com.tn.cinema.services.UsersFacadeRemote;

/**
 * Session Bean implementation class UsersFacade
 */

@Stateless
public class UsersFacade implements UsersFacadeRemote, UsersFacadeLocal {

	@EJB
	AdministratorServiceLocal aLocal;
	@EJB
	ManagerServiceLocal mLocal;
    /**
     * Default constructor. 
     */
    public UsersFacade() {
        // TODO Auto-generated constructor stub
    }

    @Override
	public User authenticate(String email, String password) {
		User u=null;
		
		u=aLocal.findAdministratorByEmailAndPassword(email, password);
		if(u!=null) return u;
		
		u=mLocal.findManagerByEmailAndPassword(email, password);
		if(u!=null) return u;
		
		return u;
	}
    
    
    
    
}
