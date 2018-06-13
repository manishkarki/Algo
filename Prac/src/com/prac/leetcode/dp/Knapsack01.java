package com.prac.leetcode.dp;

/**
 * @author Manish Karki
 * 
 */

public class Knapsack01 {

	public static int knapSack(int[] value, int[] wt, int W) {
		int[][] dp = new int[value.length + 1][W + 1];

		for (int i = 0; i <= value.length; i++) {
			for (int j = 0; j <= W; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
					continue;
				}

				if (wt[i - 1] <= j)
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - (wt[i - 1])] + value[i - 1]);
				else
					dp[i][j] = dp[i - 1][j];
			}
		}

		return dp[value.length][W];
	}

	public static void main(String[] args) {
		int val[] = { 22, 20, 15, 30, 24, 54, 21, 32, 18, 25 };
		int wt[] = { 4, 2, 3, 5, 5, 6, 9, 7, 8, 10 };
		long startTime = System.currentTimeMillis();
		System.out.println(knapSack(val, wt, 30));
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println("elapsed::"+elapsedTime);
	}

}
