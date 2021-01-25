package com.expansion;

import java.util.Random;

import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.map.LinkedMap;

public class FileStorage {

	static String[] storeDimension = {"0", "0"};
	static OrderedMap<String, String> cellData = new LinkedMap<String, String>();

	static String generateASCII() {

			String randomString;
			String ascii;
			String alphabet; 		
  			StringBuilder as = new StringBuilder();

  			for (int c = 32 ; c <= 127 ; c++) {
					ascii = String.format("%c",c);
					as.append(ascii);
			}
			
  			alphabet = as.toString();
			StringBuilder sb = new StringBuilder();
  			Random random = new Random();

		  	for (int i = 0 ; i < 3 ; i++) {
		  		int index = random.nextInt(alphabet.length());
		  		char randomChar = alphabet.charAt(index);
		  		sb.append(randomChar);
		  	}
		  	randomString = sb.toString();
	  		return randomString;	  		  
	}


}