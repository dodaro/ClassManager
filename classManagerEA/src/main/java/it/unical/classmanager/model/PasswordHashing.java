package it.unical.classmanager.model;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Random;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PasswordHashing {

	/**
	 * Iterations for the hash
	 */
	private static final int ITERATIONS = 4096;
	
	/**
	 * 32 bytes key and salt length for 256 bit keys and salt
	 */
	private static final int KEYLENGTH = 32;
	
	
	/**
	 * The method computes the hash of the given password using a 128 bit salt string randomly generated
	 * @param password for which you intend to compute the hash
	 * @return
	 */
	public static String getHashAndSalt(String password) {
	

		final Random r = new SecureRandom();
		byte[] salt = new byte[KEYLENGTH];
		r.nextBytes(salt);

		byte[] key = null;
	
		KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, ITERATIONS, KEYLENGTH * 8);
		
		SecretKeyFactory f;
		try {
			f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
			key = f.generateSecret(spec).getEncoded();
		} catch ( NoSuchAlgorithmException e ) {
			//TODO handle here 
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			// TODO Honestly I don't know how to handle this
			e.printStackTrace();
		}
		
		return byteArrayToHex(key)+":"+byteArrayToHex(salt);
	}
	

	/**
	 * Utility method to convert a ByteArray to hex string, to be stored in the DB
	 * @param a byteArray to convert.
	 * @return hex String representing the given byteArray
	 */
	private static String byteArrayToHex(byte[] a) {
	   StringBuilder sb = new StringBuilder(a.length * 2);
	   for(byte b: a)
	      sb.append(String.format("%02x", b & 0xff));
	   return sb.toString();
	}
	
}
