package com.prac.leetcode.dp;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Manish Karki
 * 
 */

public class LongestSubString {
	public static int lengthOfLongestSubstring(String s) {

		int i = 0, j = 0, maximum = 0;
		Set<Character> longestSubString = new LinkedHashSet<>();

		while (j < s.length()) {
			if (!longestSubString.contains(s.charAt(j))) {
				System.out.println("at j:"+j+" s.charAt(j):"+s.charAt(j));
				longestSubString.add(s.charAt(j++));
				System.out.println("after addition in set::"+longestSubString);
				maximum = Math.max(maximum, longestSubString.size());
			} else {
				System.out.println("\t In else: char is::"+s.charAt(j)+" set is:"+longestSubString);
				longestSubString.remove(s.charAt(i++));
				System.out.println("\t after removal of::"+ s.charAt(i-1)+" at "+(i-1)+" set is:"+longestSubString);
			}
		}

		return maximum;

	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("manishabinm"));
	}

}
