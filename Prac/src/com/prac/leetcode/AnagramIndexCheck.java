package com.prac.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Manish Karki
 * 
 */

public class AnagramIndexCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String haystack = "abbababaaabbbb";
		String needle = "ab";

		for (int a : checkAnagram(needle, haystack)) {
			System.out.println(a);
		}

	}

	public static List<Integer> checkAnagram(String n, String h) {
		char[] needle = n.toCharArray();
		char[] haystack = h.toCharArray();
		int M = n.length(), N = h.length();
		List<Integer> myList=new ArrayList<>();		
		 
	    // countP[]:  Store count of all characters of pattern
	    // countTW[]: Store count of current window of text
	    int countP[] = new int[128], countTW[] = new int[128];
	    Arrays.fill(countP, 0);
	    Arrays.fill(countTW, 0);
	    for (int i = 0; i < M; i++)
	    {
	        (countP[needle[i]])++;
	        (countTW[haystack[i]])++;
	    }
	 
	    // Traverse through remaining characters of pattern
	    for (int i = M; i < N; i++)
	    {
	        // Compare counts of current window of text with
	        // counts of pattern[]
	        if (compare(countP, countTW))
	        	myList.add(i-M);
	           	 
	        // Add current character to current window
	        (countTW[haystack[i]])++;
	 
	        // Remove the first character of previous window
	        countTW[haystack[i-M]]--;
	    }
	 
	    // Check for the last window in text
	    if (compare(countP, countTW))
	    	myList.add(N-M);
	        
		return myList;
	}
	
	static boolean compare(int arr1[], int arr2[])
	{
	    for (int i=0; i<128; i++)
	        if (arr1[i] != arr2[i])
	            return false;
	    return true;
	}
}
