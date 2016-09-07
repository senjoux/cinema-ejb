package utils;

import static org.junit.Assert.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.junit.Ignore;
import org.junit.Test;
@Ignore
public class EncryptionTest {

	@Test
	@Ignore
	public void test() {
		//ex output : %+)
		String salt=generateSalt(4);
		//ex output : ���ӑ�.g�o��lmk�*�m�z�Qs=Ҍ�N
		String hashedPwd=hashPassword("hamza",salt);
		//System.out.println("salt --->   " + salt);
		//System.out.println("pwd --->   " + hashedPwd);
		assertEquals("���ӑ�.g�o��lmk�*�m�z�Qs=Ҍ�N", hashPassword("hamza", "%+)"));
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
