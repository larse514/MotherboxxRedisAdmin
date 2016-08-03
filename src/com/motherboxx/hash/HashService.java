package com.motherboxx.hash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class HashService {

	private MessageDigest md;
	
	@PostConstruct
	public void init() throws NoSuchAlgorithmException{
        md = MessageDigest.getInstance("MD5");
	}
	public String hashValue(String value){
        md.update(value.getBytes());
        byte byteData[] = md.digest();
        
        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        
        return sb.toString();

	}
}
