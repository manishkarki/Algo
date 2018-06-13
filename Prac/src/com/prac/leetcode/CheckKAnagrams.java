package com.prac.leetcode;

/**
 * 
 * Given two strings of lower-case alphabets and a value k, the task is to find
 * if two strings are K-anagrams of each other or not.
 * 
 * Two strings are called k-anagrams if following two conditions are true.
 * 
 * Both have same number of characters. Two strings can become anagram by
 * changing at most k characters in a string.
 * 
 * 
 * @author mKarki
 * 
 */

public class CheckKAnagrams {
	private final static int MAX_CHAR = 26;

	static boolean areKAnagrams(String input1, String input2, int k) {
		// edge case, if both strings are not of equal
		// length then return false
		int n = input1.length();
		if (input2.length() != n)
			return false;

		int[] counterCache = new int[MAX_CHAR];

		// Store the occurrence of all characters
		// in the local cache
		for (int i = 0; i < n; i++)
			counterCache[input1.charAt(i) - 'a']++;

		// reduce the count from hash, if the char matches
		// else increment the counter
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (counterCache[input2.charAt(i) - 'a'] > 0)
				counterCache[input2.charAt(i) - 'a']--;
			else
				count++;

			if (count > k)
				return false;
		}
		return true;
	}

}
