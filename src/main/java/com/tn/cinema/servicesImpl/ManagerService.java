package com.tn.cinema.servicesImpl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.tn.cinema.entities.Manager;
import com.tn.cinema.services.ManagerServiceLocal;
import com.tn.cinema.services.ManagerServiceRemote;
import com.tn.cinema.services.UtilityServiceLocal;

/**
 * Session Bean implementation class ManagerService
 */
@Stateless
public class ManagerService implements ManagerServiceRemote, ManagerServiceLocal {

	@PersistenceContext
	EntityManager em;
	@EJB
	UtilityServiceLocal utility;
	
    /**
     * Default constructor. 
     */
    public ManagerService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean addManager(Manager m) {
		try {
			m.setSalt(utility.generateSalt(5));
			m.setPassword(utility.hashPassword(m.getPassword(), m.getSalt()));
			em.persist(m);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateManager(Manager m) {
		try {
			em.merge(m);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteManager(Manager m) {
		try {
			em.remove(em.merge(m));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Manager> findAllManagers() {
		Query q=em.createQuery("select m from Manager m");	
		return q.getResultList();
	}

	@Override
	public Manager findManagerByID(Integer id) {
		Manager m=null;
		try {
			m=em.find(Manager.class,id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return m;
	}

	@Override
	public Manager findManagerByEmail(String email) {
		Manager m=null;
		Query q=em.createQuery("select m from Manager m where m.email = :param1").setParameter("param1", email);
		try {
			m=(Manager) q.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return m;
	}

	@Override
	public Manager findManagerByEmailAndPassword(String email, String password) {
		Manager m=findManagerByEmail(email);
		if (m==null) return null;
		String hashedPassword =utility.hashPassword(password, m.getSalt());
		if(hashedPassword.equals(m.getPassword())) return m;
		return null;
	}

}
