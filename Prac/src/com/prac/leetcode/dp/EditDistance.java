package com.prac.leetcode.dp;

/**
 * Given two strings how many minimum edits(update, delete or add) is needed to convert one string to another
 *
 * Time complexity is O(m*n)
 * Space complexity is O(m*n)
 *
 * @author Manish Karki
 * 
 */

public class EditDistance {
	
	public static int minEditDistance(String s1,String s2){
		
		if(s1.isEmpty() && s2.isEmpty())
			return 0;
		
		int [][] dp = new int[s1.length()+1][s2.length()+1];
		
		for(int i = 0; i< dp[0].length; i++){
			dp[0][i] = i;
		}
		
		for(int i = 0; i< dp.length; i++){
			dp[i][0] = i;
		}
		
		for(int i = 1; i <= s1.length(); i++){
			for(int j = 1; j <= s2.length();j++){
				if(s1.charAt(i-1) == s2.charAt(j-1))
					dp[i][j] = dp[i-1][j-1];
				else
					dp[i][j] = 1+ min(dp[i-1][j-1],dp[i-1][j],dp[i][j-1]);
			}
		}
		printActualEdits(dp, s1.toCharArray(), s2.toCharArray());
		return dp[s1.length()][s2.length()];
	}

	/**
     * Prints the actual edits which needs to be done.
     */
    public static void printActualEdits(int T[][], char[] str1, char[] str2) {
        int i = T.length - 1;
        int j = T[0].length - 1;
        while(true) {
            if (i == 0 || j == 0) {
                break;
            }
            if (str1[i-1] == str2[j-1]) {
                i = i-1;
                j = j-1;
            } else if (T[i][j] == T[i-1][j-1] + 1){
                System.out.println("Edit " + str2[j-1] + " in string2 to " + str1[i-1] + " in string1");
                i = i-1;
                j = j-1;
            } else if (T[i][j] == T[i-1][j] + 1) {
                System.out.println("Delete in string1 " + str1[i-1]);
                i = i-1;
            } else if (T[i][j] == T[i][j-1] + 1){
                System.out.println("Delete in string2 " + str2[j-1]);
                j = j -1;
            } else {
                throw new IllegalArgumentException("Some wrong with given data");
            }

        }
    }
	
	private static int min(int i, int j, int k) {
		int ref = Math.min(i, j);
		int ret = Math.min(ref, k);
		return ret;
	}
	
	public static void main(String[] args) {
		System.out.println(minEditDistance("azced","abcdef"));
	}

}
