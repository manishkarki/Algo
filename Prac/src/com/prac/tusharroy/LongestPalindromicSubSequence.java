package com.prac.tusharroy;

/**
 * @author Manish Karki
 * 
 */

public class LongestPalindromicSubSequence {
	
	public static int longestPalindromiceSubsequence(String str){
		int [][] dp = new int[str.length()][str.length()];
		
		for(int i = 0; i< str.length(); i++){
			dp[i][i] = 1;
		}
		
		for(int l = 2; l <= str.length(); l++){
			for(int i = 0; i< str.length(); i++){
				int j = l+i-1;
				if(str.charAt(i) == str.charAt(j) && l == 2)
					dp[i][j] = 2;
				else if( str.charAt(i) == str.charAt(j))
					dp[i][j] = dp[i+1][j-1]+2;
				else
					dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
			}
		}
		
		return dp[0][str.length()-1];
	}

}
