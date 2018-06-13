package com.prac.tusharroy;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Your algorithms have become so good at predicting the market that you now know what the share price of Wooden Orange Toothpicks Inc.
 *	(WOT) will be for the next N days.
 *	Each day, you can either buy one share of WOT, sell any number of shares of WOT that you own, or not make any transaction at all. 
 *	What is the maximum profit you can obtain with an optimum trading strategy?
	
 *	//Input Format
 *	The first line contains the number of test cases T. T test cases follow:
	
 *	The first line of each test case contains a number N. The next line contains N integers, denoting the predicted price of WOT shares for
 *	the next N days.
	
 *	//Constraints
 *	All share prices are between 1 and 100000
 
 *	Output Format
 *	Output T lines, containing the maximum profit which can be obtained for the corresponding test case.
 */

/**
 * @author Manish Karki
 *
 *         Jul 4, 2017
 */
public class StockMaxmProfit {
 
	public static int maxProfit(int prices[], int K) {
		if (K == 0 || prices.length == 0) {
			return 0;
		}
		int T[][] = new int[K + 1][prices.length];

		for (int i = 1; i < T.length; i++) {
			int maxDiff = -prices[0];
			for (int j = 1; j < T[0].length; j++) {
				T[i][j] = Math.max(T[i][j - 1], prices[j] + maxDiff);
				maxDiff = Math.max(maxDiff, T[i - 1][j] - prices[j]);
			}
		}
		printActualSolution(T, prices);
		return T[K][prices.length - 1];
	}

	public static void printActualSolution(int T[][], int prices[]) {
		int i = T.length - 1;
		int j = T[0].length - 1;

		Deque<Integer> stack = new LinkedList<>();
		while (true) {
			if (i == 0 || j == 0) {
				break;
			}
			if (T[i][j] == T[i][j - 1]) {
				j = j - 1;
			} else {
				stack.addFirst(j);
				int maxDiff = T[i][j] - prices[j];
				for (int k = j - 1; k >= 0; k--) {
					if (T[i - 1][k] - prices[k] == maxDiff) {
						i = i - 1;
						j = k;
						stack.addFirst(j);
						break;
					}
				}
			}
		}

		while (!stack.isEmpty()) {
			System.out.println("Buy at price " + prices[stack.pollFirst()]);
			System.out.println("Sell at price " + prices[stack.pollFirst()]);
		}

	}

	public static long stockMaxProfit(int[] prices) {
		long profit = 0L;
		int maxUntilNow = 0;
		for (int i = prices.length - 1; i >= 0; i--) {
			if (prices[i] >= maxUntilNow) {
				maxUntilNow = prices[i];
			}
			profit += maxUntilNow - prices[i];
		}
		return profit;
	}

	public static void main(String[] args) {
		System.out.println(stockMaxProfit(new int[] { 5, 3, 2 }));
		System.out.println(maxProfit(new int[] { 1, 2, 100 }, 1));
		System.out.println(stockMaxProfit(new int[] { 1, 3, 1, 2 }));
	}

}
