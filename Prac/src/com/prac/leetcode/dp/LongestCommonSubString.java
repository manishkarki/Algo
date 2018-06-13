package com.prac.leetcode.dp;

/**
 * @author Manish Karki
 * 
 */

public class LongestCommonSubString {

	//method below finds len of substring of two Strings, example abcdf and zbcdaf, its bcd and length is 3.
	public static int lengthLCSS(String s1, String s2){
		return lengthLCSS(s1.toCharArray(), s2.toCharArray());
	}
	static int max =  0;
	private static int lengthLCSS(char[] s1, char[] s2) {
		int [][] dp = new int[s1.length+1][s2.length+1];
		for(int i = 1; i< s1.length; i++){
			for(int j = 1; j < s2.length; j++){
				if(s1[i-1]== s2[j-1])
					dp[i][j] = 1+ dp[i-1][j-1];
				if(max < dp[i][j])
					max = dp[i][j];
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		System.out.println(lengthLCSS("abcdf", "zbcdaf"));
	}
}
