package it.unical.classmanager.model;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Random;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PasswordHashing {

	public static String getHashAndSalt(String password) {
	

		final Random r = new SecureRandom();
		byte[] salt = new byte[32];
		r.nextBytes(salt);
		int its = 4096;
		int keyLength = 32;
		
		byte[] key = null;
		try {
			key = getEncryptedPassword(password, salt, its, keyLength);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return byteArrayToHex(key)+":"+byteArrayToHex(salt);
	}
	
	
	private static byte[] getEncryptedPassword(String password, byte[] salt,  int iterations,  int derivedKeyLength) throws NoSuchAlgorithmException, InvalidKeySpecException {
	    KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterations, derivedKeyLength * 8);

	    SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
	    
	    return f.generateSecret(spec).getEncoded();
	}
	
	private static String byteArrayToHex(byte[] a) {
	   StringBuilder sb = new StringBuilder(a.length * 2);
	   for(byte b: a)
	      sb.append(String.format("%02x", b & 0xff));
	   return sb.toString();
	}
	
}
