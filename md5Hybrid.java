package com.krakenj.md5Hybrid;

import java.nio.charset.StandardCharsets;
import java.security.*;



public class md5Hybrid{
	
	void md5Hybrid(){
	//code here
	}
	
	public static void main(String [] args){
	
	
	
	int[] mcode = new int[] {3,5,6,4,1,2,0,7};	
	
	
		
	String str = md5hybrid("rolly", mcode);
		
	System.out.println(str);	
	for(int i=0; i<8; i++)System.out.print(mcode[i]);		
		
		
	}//main 




	public static String md5hybrid(String pass, int[] mcode){
		
		//cound how many digit the mcode 
		int counter = 0;
		for (int i = 0; i < mcode.length; i ++) counter ++;	
		
		//hash the passw2ord
		String hashedTextPassString = MD5(pass);
		
		//convert md5 hash string into char array
		char[] hashedTextPassCharArr; 
		hashedTextPassCharArr = hashedTextPassString.toCharArray();	

		//CALCULATE CHUNCK LENGTH
		int chunkLenght = 32/(counter-1);							
		System.out.println("chunkLenght = " + chunkLenght);	

		//INSERT COMMA BETWEEN CHUNKS
		int l, n = 0;
		String strArr = "";
		for(l=0;l < 32;l++){
			++n;
			strArr += hashedTextPassCharArr[l];
			if(n == chunkLenght) { strArr += ","; n = 0;}
		}//
		
		//separate delimited string
		String[] output = strArr.split(",");		


		//count how many index in the array		
		int index_count = 0;
		for (int i = 0; i < output.length; i++)
			if (output[i] != null) index_count++;


		//SCRAMBLER!
		int j,i;
		String scrambledEgg = "";
		for(j = 0; j != 8; j++){		
			for(i = 0; i != (8+1); i++){
				if(mcode[j] == i){
					scrambledEgg += output[i] + " ";					
				}	
			}		
		}//for j;			
		
		
		
		
		/******************************/
		return scrambledEgg;
		
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

