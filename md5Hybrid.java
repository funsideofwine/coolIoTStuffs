package com.krakenj.md5Hybrid;

import java.nio.charset.StandardCharsets;
import java.security.*;



public class md5Hybrid{
	
	void md5Hybrid(){
	//code here
	}
	
	public static void main(String [] args){
		//
		//System.out.println("hello");
		//String[] spl = "dfada,fadfadfad,dfgdfgd,fdafafad,fadafa".split(",");
		
		String s="rolly";
		String texthashed;
		
		texthashed = MD5(s);
		
        //MessageDigest m=MessageDigest.getInstance("MD5");
        //m.update(s.getBytes(),0,s.length());
        //System.out.println("MD5: "+new BigInteger(1,m.digest()).toString(16));
		System.out.println(texthashed);
		}
		
	
	
	public static String MD5(String md5) {
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
			byte[] array = md.digest(md5.getBytes());
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < array.length; ++i) {
			  sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
		   }
			return sb.toString();
		} catch (java.security.NoSuchAlgorithmException e) {
		}
    return null;
	}
	
}


