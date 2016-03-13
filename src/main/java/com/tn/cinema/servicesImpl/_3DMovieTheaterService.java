package com.tn.cinema.servicesImpl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.tn.cinema.entities.Manager;
import com.tn.cinema.entities._3DMovieTheater;
import com.tn.cinema.services._3DMovieTheaterServiceLocal;
import com.tn.cinema.services._3DMovieTheaterServiceRemote;

/**
 * Session Bean implementation class _3DMovieTheaterService
 */
@Stateless
public class _3DMovieTheaterService implements _3DMovieTheaterServiceRemote, _3DMovieTheaterServiceLocal {

	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public _3DMovieTheaterService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean add_3DMovieTheater(_3DMovieTheater mt) {
		try {
			em.persist(mt);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public _3DMovieTheater find_3DMovieTheaterByID(Integer id) {
		return em.find(_3DMovieTheater.class, id);
	}

	@Override
	public boolean update_3DMovieTheater(_3DMovieTheater mt) {
		try {
			em.merge(mt);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete_3DMovieTheater(_3DMovieTheater mt) {
		try {
			em.remove(em.merge(mt));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<_3DMovieTheater> getAll_3DMovieTheaters() {
		Query q=em.createQuery("select t from _3DMovieTheater t");
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<_3DMovieTheater> get_3DMovieTheatersByManager(Manager m) {
		Query q=em.createQuery("select t from _3DMovieTheater t where t.manager =:x");
		q.setParameter("x", m);
		return q.getResultList();
	}

	

}
