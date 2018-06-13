package com.prac.leetcode.dp;

/**
 * @author Manish Karki
 * 
 */

public class OptimalSearchTree {
	
	//Given nodes values and frequency of it's search, find the minimum cost BST
	
	public static int minCost(int[] arr, int[] freq){
		
		int [][] dp = new int[arr.length][arr.length];
		for(int i = 0; i< dp.length; i++){
			dp[i][i] = freq[i];
		}
		
		for(int l = 2; l <=arr.length; l++){
			for(int i = 0; i <= arr.length-l; i++){
				int j = i + l -1;
				dp[i][j] = Integer.MAX_VALUE;
				int sum = getSum(freq, i, j);
				
				for(int k=i; k <= j; k++){
                    int val = sum + (k-1 < i ? 0 : dp[i][k-1]) +
                           (k+1 > j ? 0 : dp[k+1][j]) ;
                    if(val < dp[i][j]){
                        dp[i][j] = val;
                    }
               }
			}
		}
		
		return dp[0][arr.length-1];
	}
	

	private static int getSum(int freq[], int i, int j){
        int sum = 0;
        for(int x = i; x <= j; x++){
            sum += freq[x];
        }
        return sum;
    }
	
	public static void main(String[] args) {
		int input[] = {10,12,20,35,46};
        int freq[] = {34,8,50,21,16};
        System.out.println(minCost(input, freq));
	}

}
