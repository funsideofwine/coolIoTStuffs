package com.krakenj.md5Hybrid;

import java.nio.charset.StandardCharsets;
import java.security.*;



public class md5Hybrid_v1{
	
	void md5Hybrid(){
	//code here
	}
	
	public static void main(String [] args){
		
		//inputs
		//plainTextPassString
		//totalDigitCodes
		
		String plainTextPassString = "rolly";
		//DISPLAY MCODE		
		System.out.println("PLAIN TEXT PASSWORD = " + plainTextPassString);
		
		
		
		
		int[] mcode = new int[] {5,0,4,1,6,2,3,7,8,9};
		
			
		//DISPLAY MCODE		
		System.out.print("MCODE = ");
		for (int i = 0; i < mcode.length; i ++){
			
			System.out.print(" " + mcode[i]);
		}

		//cound how many digit the mcode 
		int counter = 0;
		for (int i = 0; i < mcode.length; i ++)
			//if (mcode[i] != null)
				counter ++;		
		int totalDigitCodes = counter;
		System.out.println("");
		System.out.println("HOW MANY DIGIT IN MCODE = " + counter);		
		
		//declare
		String hashedTextPassString;
		//hash it
		hashedTextPassString = MD5(plainTextPassString);
		//display md5 hash
		
		System.out.println("MD5 STRING = " + hashedTextPassString);
	
		//convert md5 hash strin to char array
		char[] hashedTextPassCharArr; 
		hashedTextPassCharArr = hashedTextPassString.toCharArray();
		
		//DISPLAY MD5 CHAR ARRAY		
		System.out.print("MD5 CHAR ARRAY = ");
		for (int i = 0; i < hashedTextPassCharArr.length; i ++){
			
			System.out.print("" + hashedTextPassCharArr[i]);
		}
		
		//
		//cound how many character is the md5hash 
		int counter_a = 0;
		for (int i = 0; i < hashedTextPassCharArr.length; i ++)
			//if (mcode[i] != null)
				counter_a ++;
			
		int hashedTextPassCharArrLength = counter_a; //hashedTextPassCharArr.length;		
		System.out.println("");
		System.out.println("TOTAL CHARACTERS IN MD5 CHAR ARRAY HASH = " + counter_a);		
		
		

		
		//CALCULATE CHUNCK LENGTH
		int chunkLenght = hashedTextPassCharArrLength/(totalDigitCodes-1);							
		System.out.println("chunkLenght = " + chunkLenght);	
		
		String strArr   = "";
		String strArr1  = "";
		int n=0,l=0,m=0;
		
			
			//INSERT COMMA BETWEEN CHUNKS	
			for(l=1;l < hashedTextPassCharArrLength;l++){
				++n;
				strArr += hashedTextPassCharArr[l-1];
				if(n == chunkLenght) { strArr += ","; n = 0;}
			}
		

		//separate delimited string
		String[] output = strArr.split(",");
		

		//count how many index in the array		
		int counter1		= 0;
		for (int i = 0; i < output.length; i++)
			if (output[i] != null) counter1++;
			
		
		System.out.print("ORIGINAL HASH ");		
		
		//display array	
		for(int i=0; i < counter1;i++){
			System.out.print(output[i] + " ");	
		}			
		
		//int howManyDigit;
		//howManyDigit = counter1;
	
		
		//SCRAMBLER!
		int j,i;
		String scrambledEgg = "";
		for(j = 0; j != totalDigitCodes; j++){		
			for(i = 0; i != (totalDigitCodes+1); i++){
				if(mcode[j] == i){
					scrambledEgg += output[i] + " ";					
				}	
			}		
		}//for j;	
		
		
		//display mcode
		//for(i=0; i < counter;i++){
		//	System.out.print(mcode[i] + " ");
		//}	
		
		
		System.out.println("");
		System.out.println("SCRAMBLED HASH = " + scrambledEgg);
		
		
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

