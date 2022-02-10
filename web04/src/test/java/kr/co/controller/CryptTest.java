package kr.co.controller;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.junit.Test;

import kr.co.util.CryptoUtil;


public class CryptTest {
	
	@Test
	public void cryptoTest() throws NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException, 
	NoSuchPaddingException, InvalidParameterSpecException, UnsupportedEncodingException, BadPaddingException, 
	IllegalBlockSizeException, InvalidAlgorithmParameterException {
		String plainText = "Hi~! Spring~!";
		String key = "1234";
		
		System.out.println("MD5 암호화 : "+CryptoUtil.md5(plainText));
		System.out.println("SHA-256 암호화 : "+CryptoUtil.sha256(plainText));
		
		String encrypted = CryptoUtil.encryptAES256(plainText, key);
		System.out.println("AES-256 : 암호화 : "+encrypted);
		System.out.println("AES-256 : 복호화 : "+CryptoUtil.decryptAES256(encrypted, key));
		
	}
}