package com.tn.cinema.services;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.tn.cinema.entities.Movie;
import com.tn.cinema.entities.MovieTheater;
import com.tn.cinema.entities.Session;
import com.tn.cinema.entities.SessionID;

@Local
public interface SessionServiceLocal {

	boolean addSession(Session session);
	Session findSessionByID(SessionID id);
	boolean updateSession(Session session);
	boolean deleteSession(Session session);
	List<Session> findAllSessions();
	List<Session> findAllSessionsByMovie(Movie movie);
	List<Session> findAllSessionsByMovieTheater(MovieTheater movieTheater);
	List<Session> findAllSessionsByDate(Date date);
}
