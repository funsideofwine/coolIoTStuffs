package com.krakenj.md5Hybrid;

import java.nio.charset.StandardCharsets;
import java.security.*;



public class md5Hybrid_v1{
	
	void md5Hybrid(){
	//code here
	}
	
	public static void main(String [] args){


	
		String plainTextPassString = "rolly";		
		//declare
		String hashedTextPassString;
		//hash it
		hashedTextPassString = MD5(plainTextPassString);
		//verify
		System.out.println("hashedTextPassString = " + hashedTextPassString);
		//System.out.println("hashedTextPassString = " + hashedTextPassString.length());
		
		//convert string to char array
		//hashedTextPassString = "01234567890123456789012345678901";
		
		char[] hashedTextPassCharArr; 
		hashedTextPassCharArr = hashedTextPassString.toCharArray();
		
		//System.out.println("hashedTextPassCharArr[0]" + hashedTextPassCharArr[0]);
		//System.out.println("hashedTextPassCharArr[1]" + hashedTextPassCharArr[1]);
		//System.out.println("hashedTextPassCharArr[2]" + hashedTextPassCharArr[2]);
		
		int hashedTextPassCharArrLength = hashedTextPassCharArr.length;		
		System.out.println("hashedTextPassCharArr = " + hashedTextPassCharArr);
		System.out.println("hashedTextPassCharArrLength = " + hashedTextPassCharArrLength);
		
		
		
		
		
		
		int totalDigitCodes = 9;
		int chunkLenght = hashedTextPassCharArrLength/totalDigitCodes;		
				
		System.out.println("totalDigitCodes = " + totalDigitCodes);		
		System.out.println("chunkLenght = " + chunkLenght);	


		
		String strArr   = "";
		String strArr1  = "";
		int n=0,l=0,m=0;
		//for(k=0;k < 15;++k){
				
			for(l=1;l < hashedTextPassCharArrLength;l++){
				++n;
				strArr += hashedTextPassCharArr[l-1];
				if(n == chunkLenght) { strArr += ","; n = 0;}
			}
		

		//separate delimited string
		String[] output = strArr.split(",");
		System.out.println("output = " + output[0]);	
		
		
		//count how many index in the array
		
		int counter = 0;
		for (int i = 0; i < output.length; i ++)
			if (output[i] != null) counter ++;
			
		System.out.println("counter = " + counter);	
		
			
		/*
        for(int j=0;j<4;++j){  
            for(int i=0;i<chunkLenght;++i){            	
            	strArr[j] += hashedTextPassCharArr[i];	            
            }
        }	
		*/
		System.out.println("strArr = " + strArr);
		//System.out.println("strArr = " + strArr[1]);
		//System.out.println("strArr = " + strArr[2]);
		//System.out.println("strArr = " + strArr[3]);
		
		/*
		String[] strArr = new String(32);
		String[] charArr = new String[32];
        
        strPassHashed = MD5(strPlainTextPass.toString);
        
        //convert String array to Char Array
		//charArr = strPassHashed.toCharArray();
        System.out.println("strPassHashed = " + strPassHashed);
		System.out.println("charArr = " + charArr);
		
		int key = 8;
		int chunkLenght = 32/key;
		
		
		//System.out.println("Hash Lenght = " + charArr.);
		System.out.println("key = " + key);		
		System.out.println("chunkLenght = " + chunkLenght);
		
		
	
		
		
		
        
        for(int j=0;j<key;++j){  
            for(int i=0;i<chunkLenght;++i){            	
            	strArr[j] += charArr[i];	            
            }
        }
		
		//System.out.println("ch[0] = " + ch[0]);
		System.out.println("strArr[0] = " + strArr[0]);
		System.out.println("strArr[1] = " + strArr[1]);
		System.out.println("strArr[2] = " + strArr[2]);
		System.out.println("strArr[3] = " + strArr[3]);
		System.out.println("strArr[4] = " + strArr[4]);
		System.out.println("strArr[5] = " + strArr[5]);
		System.out.println("strArr[6] = " + strArr[6]);
		System.out.println("strArr[7] = " + strArr[7]);
		System.out.println("strArr[8] = " + strArr[8]);
		System.out.println("strArr = " + strArr);
		*/
		
	}//main 		
	
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

