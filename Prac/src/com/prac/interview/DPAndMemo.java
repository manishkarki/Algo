package com.prac.interview;

/**
 * @author Manish Karki
 * 
 */

public class DPAndMemo {

	// recursively
	public static int fibonacci(int n) {
		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	// using memoization
	public static int fibonacci(int n, int[] memo) {
		if (n <= 0)
			return 0;
		else if (n == 1)
			return 1;

		else if (memo[n] == 0) {
			memo[n] = fibonacci(n - 1, memo) + fibonacci(n - 2, memo);
		}
		return memo[n];
	}

	// similarly for counting paths from top left of a grid to bottom right, we
	// can better use memoization

	public static int countPaths(int[][] grid, int row, int col, int[][] paths) {
		if (!isSafe(grid, row, col))
			return 0;

		if (isAtEnd(grid, row, col))
			return 1;

		if (paths[row][col] == 0)
			paths[row][col] = countPaths(grid, row + 1, col, paths) + countPaths(grid, row, col + 1, paths);

		return paths[row][col];
	}

	private static boolean isAtEnd(int[][] grid, int row, int col) {
		return (row == grid.length - 1 && col == grid[row].length);
	}

	private static boolean isSafe(int[][] grid, int row, int col) {
		return (row >= 0 && row < grid.length && col >= 0 && col < grid[row].length && grid[row][col] == 1);
	}

	public static void main(String[] args) {
		System.out.println(fibonacci(4));
		System.out.println(fibonacci(4, new int[5]));
	}

}
