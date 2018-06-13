package com.prac.leetcode.dp;

/**
 * @author Manish Karki
 * 
 */

public class LongestCommonSubSequence {

	public static int lengthLCSS(String s1, String s2) {
		return getLongestCSS(s1.toCharArray(), s2.toCharArray());
	}

	public static int getLongestCSS(char[] s1, char[] s2) {
		int[][] dp = new int[s1.length + 1][s2.length + 1];
		int max = 0;
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (s1[i - 1] == s2[j - 1])
					dp[i][j] = dp[i - 1][j - 1] + 1;
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				if (max < dp[i][j])
					max = dp[i][j];
			}
		}

		int index = dp[s1.length][s2.length];

		// Create a character array to store the lcs string
		char[] lcs = new char[index + 1];
		lcs[index] = '\0'; // Set the terminating character

		// Start from the right-most-bottom-most corner and
		// one by one store characters in lcs[]
		int i = s1.length, j = s2.length;
		while (i > 0 && j > 0) {
			// If current character in X[] and Y are same, then
			// current character is part of LCS
			if (s1[i - 1] == s2[j - 1]) {
				lcs[index - 1] = s1[i - 1]; // Put current character in result
				i--;
				j--;
				index--; // reduce values of i, j and index
			}

			// If not same, then find the larger of two and
			// go in the direction of larger value
			else if (dp[i - 1][j] > dp[i][j - 1])
				i--;
			else
				j--;
		}
		
		System.out.println(lcs);

		return max;
	}

	public static void main(String[] args) {
		
		String str1 = "ABCDGHLQR";
        String str2 = "AEDPHR";
        
        int result = lengthLCSS(str1,str2);
        System.out.print(result);

	}

}
