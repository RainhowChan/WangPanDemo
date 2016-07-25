package cn.rainhowchan.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;

public class Md5Utils {
	@Test
	public static String md5(String password){
		byte[] secretBytes=null;
		try {
			secretBytes = MessageDigest.getInstance("MD5").digest(password.getBytes());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String md5code = new BigInteger(1, secretBytes).toString(16);
		for (int i = 0; i < 32 - md5code.length(); i++) {
			md5code = "0" + md5code;
		}
		return md5code;
//		System.out.println(md5code);

	}
}
