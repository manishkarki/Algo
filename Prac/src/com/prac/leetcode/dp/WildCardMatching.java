package com.prac.leetcode.dp;


/**
 * @author Manish Karki
 * 
 */

public class WildCardMatching {

	/*
	 * Implement wildcard pattern matching with support for '?' and '*'.

	'?' Matches any single character.
	'*' Matches any sequence of characters (including the empty sequence).

	The matching should cover the entire input string (not partial).

	The function prototype should be:
	bool isMatch(const char *s, const char *p)

	Some examples:
	isMatch("aa","a") → false
	isMatch("aa","aa") → true
	isMatch("aaa","aa") → false
	isMatch("aa", "*") → true
	isMatch("aa", "a*") → true
	isMatch("ab", "?*") → true
	isMatch("aab", "c*a*b") → false
	*/
	
	public static boolean isMatch(String s, String p) {
		int m = s.length(), n = p.length();
		boolean[][] dp = new boolean[m + 1][n + 1];
		dp[0][0] = true;
		for (int i = 1; i <= m; i++) {
			dp[i][0] = false;
		}

		// length of S _> 0, but * in p char
		for (int j = 1; j <= n; j++) {
			if (p.charAt(j - 1) == '*') {
				dp[0][j] = true;
			} else {
				break;
			}
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (p.charAt(j - 1) != '*') {
					dp[i][j] = dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?');
				} else {
					dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
				}
				System.out.print(" dp["+i+"]"+"["+j+"]:"+dp[i][j]);
			}
			System.out.println();
		}
		return dp[m][n];
	}
	
	/**
	 * 
	 * @param input Array of positive numbers in the sorted order.
	 * @param x 
	 */
	private static void editArray(int[] arr, int m) {

		int cur, cur_ele = -1;
		int count = 0;
	    
		cur = 0;
		
		for(int i = 0;i < arr.length;i++)
		{
			if (cur_ele != arr[i])
			{
				cur_ele = arr[i];
				count = 0;
			}

			if (cur_ele == arr[i] && count < Math.min(m, 2))
			{
	            		count++;
	            		arr[cur] = arr[i];
	            		cur++;
	        	}
	    	}
	    
	    	for(int i = cur;i < arr.length;i++)
	        	arr[i] = 0;
	}
	
	public static void main(String[] args) {
		System.out.println(isMatch("aa","a")); 
		System.out.println(isMatch("aa","aa")); 
		System.out.println(isMatch("aa", "*"));
		int [] inputArr = new int[]{2,2,2,2,3};
		editArray(inputArr, 3);
		
		for(int i = 0 ; i< inputArr.length; i++){
			System.out.print(inputArr[i]+" ");
		}
	}

}
