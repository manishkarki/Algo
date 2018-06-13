package com.prac.hackerrank.algorithm;

/**
 * @author Manish Karki
 * 
 */

public class CoinChange {
	public static int change(int amount, int[] coins) {
		int[] dp = new int[amount + 1];
		dp[0] = 1;
		for (int coin : coins) {
			System.out.println("coin:"+coin);
			for (int i = coin; i <= amount; i++) {
				System.out.println("\t"+"i::->"+i+" i-coin::"+ (i-coin) +" dp[i-coin]::"+dp[i-coin]);
				dp[i] += dp[i - coin];
			}
		}
		return dp[amount];
	}
	
	public static void main(String[] args) {
		System.out.println(change(5, new int[]{1,2,5}));
	}

}
