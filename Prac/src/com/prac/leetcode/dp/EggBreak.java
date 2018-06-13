package com.prac.leetcode.dp;

/**
 * @author Manish Karki
 * 
 */

public class EggBreak {

	public static int calculate(int eggs, int floors) {
		int[][] dp = new int[eggs + 1][floors + 1];
		int temp = 0;

		for (int i = 0; i <= floors; i++) {
			dp[1][i] = i;
		}

		for (int e = 2; e <= eggs; e++) {
			for (int f = 1; f <= floors; f++) {
				dp[e][f] = Integer.MAX_VALUE;
				for (int k = 1; k <= f; k++) {
					temp = 1 + Math.max(dp[e - 1][k - 1], dp[e][f - k]);

					if (temp < dp[e][f])
						dp[e][f] = temp;
				}
			}
		}

		return dp[eggs][floors];
	}

	public static int calculateRecursive(int eggs, int floors) {
		if (floors == 0)
			return 0;
		if (eggs == 1)
			return floors;

		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= floors; i++) {
			int temp = 1 + Math.max(calculateRecursive(eggs - 1, i - 1), calculateRecursive(eggs, floors - i));

			if (temp < min)
				min = temp;
		}

		return min;
	}
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		System.out.println(calculateRecursive(2,6));
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println("elapsed::"+elapsedTime);
	}

}
