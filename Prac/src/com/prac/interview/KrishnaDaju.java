package com.prac.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * @author Manish Karki
 * 
 */

public interface KrishnaDaju {
	
	public static String longestString(String input){
		//convert the input into String array
		String [] inputArr = input.split(" ");
		//map to keep count of the maxm repeating chars in a String
		Map<Integer, String> maxmReptdString = new HashMap<>();
		
		for(String s: inputArr){
			int max = Integer.MIN_VALUE;
			int len = s.length();
			
			int rep = 0;
			for( int i = 1; i+1 < len; i++){
				if(s.charAt(i) == s.charAt(i-1))
					rep++;
				
				if( max < rep)
					max = rep;
				//in case of the repeating sequence ends at current character
				if(s.charAt(i+1) != s.charAt(i))
					rep = 0;
			}
			maxmReptdString.put(max, s);
		}
		
		int key = Integer.MIN_VALUE;
		for(Map.Entry<Integer, String> entries : maxmReptdString.entrySet()){
			if(key < entries.getKey())
				key = entries.getKey();
		}
		
		return maxmReptdString.get(key);
	}
	
	public static void main(String[] args) {
		IntStream.range(0, 10).forEach(System.out::println);
	}

}
