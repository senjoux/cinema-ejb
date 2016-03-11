package com.tn.cinema.services;

import javax.ejb.Local;

@Local
public interface UtilityServiceLocal {

	 public String generateSalt(int length);
	 public  String hashPassword(String unhashedPassword, String salt);
}
