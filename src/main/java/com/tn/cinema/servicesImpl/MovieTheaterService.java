package com.tn.cinema.servicesImpl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.tn.cinema.entities.Manager;
import com.tn.cinema.entities.MovieTheater;
import com.tn.cinema.services.MovieTheaterServiceLocal;
import com.tn.cinema.services.MovieTheaterServiceRemote;

/**
 * Session Bean implementation class MovieTheaterService
 */
@Stateless
public class MovieTheaterService implements MovieTheaterServiceRemote, MovieTheaterServiceLocal {

	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public MovieTheaterService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean addMovieTheater(MovieTheater mt) {
		try {
			em.persist(mt);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public MovieTheater findMovieTheaterByID(Integer id) {
		return em.find(MovieTheater.class, id);
	}

	@Override
	public boolean updateMovieTheater(MovieTheater mt) {
		try {
			em.merge(mt);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteMovieTheater(MovieTheater mt) {
		try {
			em.remove(em.merge(mt));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MovieTheater> getAllMovieTheaters() {
		Query q=em.createQuery("select t from MovieTheater t");
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MovieTheater> getMovieTheatersByManager(Manager m) {
		Query q=em.createQuery("select t from MovieTheater t where t.manager =:x");
		q.setParameter("x", m);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MovieTheater> getMovieTheatersByAddressLike(String address) {
		Query q=em.createQuery("select t from MovieTheater t where t.adresse LIKE :x");
		q.setParameter("x", "%"+address+"%");
		return q.getResultList();
	}

}
