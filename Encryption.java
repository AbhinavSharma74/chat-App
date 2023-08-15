package com.brainmentors.chatapp.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;

public interface Encryption {
	
	public static String passwordEncrypt(String plainPassword) throws NoSuchAlgorithmException {
		String encryptedPassword = null;
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		messageDigest.update(plainPassword.getBytes());
		byte [] encrypt = messageDigest.digest();
		System.out.println(encrypt);
		StringBuffer sBuffer = new StringBuffer();
		for(byte b : encrypt) {
			sBuffer.append(b);
		}
		encryptedPassword = sBuffer.toString();
		//System.out.println("Encrypted Password "+encryptedPassword);
		return encryptedPassword;
	}

}
