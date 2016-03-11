package com.tn.cinema.servicesImpl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.ejb.Stateless;

import com.tn.cinema.services.UtilityServiceLocal;

/**
 * Session Bean implementation class UtilityService
 */
@Stateless
public class UtilityService implements UtilityServiceLocal {

    /**
     * Default constructor. 
     */
    public UtilityService() {
        // TODO Auto-generated constructor stub
    }

    public String generateSalt(int length){
		String salt = "";
		for(int i = 0; i<length; i++){
			salt += (char) (20+Math.random()*35);
		}
		return salt;
	}
	
	public  String hashPassword(String unhashedPassword, String salt){
		MessageDigest digest;
		try{
			digest = MessageDigest.getInstance("SHA-256");
		}catch(NoSuchAlgorithmException e){
			return null;
		}
		digest.update((unhashedPassword+salt).getBytes());
		return new String(digest.digest());
	}
}
