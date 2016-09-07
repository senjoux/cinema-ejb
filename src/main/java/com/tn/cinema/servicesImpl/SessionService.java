package com.tn.cinema.servicesImpl;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.tn.cinema.entities.Movie;
import com.tn.cinema.entities.MovieTheater;
import com.tn.cinema.entities.Session;
import com.tn.cinema.entities.SessionID;
import com.tn.cinema.services.SessionServiceLocal;
import com.tn.cinema.services.SessionServiceRemote;

/**
 * Session Bean implementation class SessionService
 */
@Stateless
public class SessionService implements SessionServiceRemote, SessionServiceLocal {

	@PersistenceContext
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public SessionService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addSession(Session session) {
		try {
			em.persist(session);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Session findSessionByID(SessionID id) {
		return em.find(Session.class, id);
	}

	@Override
	public boolean updateSession(Session session) {
		try {
			em.merge(session);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteSession(Session session) {
		try {
			 em.remove(em.merge(session));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Session> findAllSessions() {
		Query q = em.createQuery("select s from Session s");
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Session> findAllSessionsByMovie(Movie movie) {
		Query q = em.createQuery("select s from Session s where s.movie =:m");
		q.setParameter("m", movie);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Session> findAllSessionsByMovieTheater(MovieTheater movieTheater) {
		Query q = em.createQuery("select s from Session s where s.movieTheater =:t");
		q.setParameter("t", movieTheater);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Session> findAllSessionsByDate(Date date) {
		Query q = em.createQuery("select s from Session s where s.id.date =:d");
		q.setParameter("d", date);
		return q.getResultList();
	}

}
