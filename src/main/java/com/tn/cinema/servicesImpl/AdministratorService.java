package com.tn.cinema.servicesImpl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.tn.cinema.entities.Administrator;
import com.tn.cinema.services.AdministratorServiceLocal;
import com.tn.cinema.services.AdministratorServiceRemote;
import com.tn.cinema.services.UtilityServiceLocal;

/**
 * Session Bean implementation class AdministratorService
 */
@Stateless
public class AdministratorService implements AdministratorServiceRemote, AdministratorServiceLocal {

	@PersistenceContext
	EntityManager em;
	@EJB
	UtilityServiceLocal utility;

	/**
	 * Default constructor.
	 */
	public AdministratorService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addAdministrator(Administrator a) {
		try {
			a.setSalt(utility.generateSalt(5));
			a.setPassword(utility.hashPassword(a.getPassword(), a.getSalt()));
			em.persist(a);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public boolean updateAdministrator(Administrator a) {
		try {
			em.merge(a);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteAdministrator(Administrator a) {
		try {
			em.remove(em.merge(a));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Administrator> findAllAdministrators() {
		Query q=em.createQuery("select a from Administrator a");	
		return q.getResultList();
	}

	@Override
	public Administrator findAdministratorByID(Integer id) {
		Administrator a = null;
		try {
			a=em.find(Administrator.class, id);
		} catch (Exception e) {
			
		}	
		return a;
	}

	@Override
	public Administrator findAdministratorByEmail(String email) {
		Administrator a=null;
		Query q=em.createQuery("select a from Administrator a where a.email = :param1").setParameter("param1", email);
		try {
			a=(Administrator) q.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return a;
	}

	@Override
	public Administrator findAdministratorByEmailAndPassword(String email, String password) {
		Administrator a=findAdministratorByEmail(email);
		//email not found
		if (a==null) return null;
		//email found, then get the hashed pwd 
		String hashedPassword =utility.hashPassword(password, a.getSalt());
		//check if password s correct
		if(hashedPassword.equals(a.getPassword())) return a;
		//if password does not match
		return null;
	}

}
