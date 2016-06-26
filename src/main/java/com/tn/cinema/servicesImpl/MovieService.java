package com.tn.cinema.servicesImpl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.tn.cinema.entities.Movie;
import com.tn.cinema.services.MovieServiceLocal;
import com.tn.cinema.services.MovieServiceRemote;

/**
 * Session Bean implementation class MovieService
 */
@Stateless
public class MovieService implements MovieServiceRemote, MovieServiceLocal {

	@PersistenceContext
	EntityManager em;
	
	
    /**
     * Default constructor. 
     */
    public MovieService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean addMovie(Movie m) {
		try {
			em.persist(m);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public Movie findMovieByID(Integer id) {
		return em.find(Movie.class, id);
	}

	@Override
	public boolean updateMovie(Movie m) {
		try {
			em.merge(m);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteMovie(Movie m) {
		try {
			em.remove(em.merge(m));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Movie> findAllMovies() {
		Query q=em.createQuery("select m from Movie m");
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Movie> findMoviesByTitleLike(String title) {
		Query q=em.createQuery("select m from Movie m where m.title LIKE :x");
		q.setParameter("x", "%"+title+"%");
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Movie> findMoviesByTypeLike(String type) {
		Query q=em.createQuery("select m from Movie m where m.type LIKE :x");
		q.setParameter("x", "%"+type+"%");
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Movie> findMoviesByStatus(boolean isApproved) {
		Query q=em.createQuery("select m from Movie m where m.approved =:a");
		q.setParameter("a", isApproved);
		return q.getResultList();
	}

}
