package com.prac.string;

/**
 * @author Manish Karki
 * 
 */

public class RotateImageBy90 {

	public static boolean rotate(int[][] matrix) {

		if (matrix.length == 0 || matrix[0].length != matrix.length)
			return false;

		int n = matrix.length;
		for (int layer = 0; layer < n / 2; layer++) {
			for (int j = 0; j < Math.ceil((double) n / 2); j++) {
				int top = matrix[layer][j];
				matrix[layer][j] = matrix[n - 1 - j][layer];
				matrix[n - 1 - j][layer] = matrix[n - 1 - layer][n - 1 - j];
				matrix[n - 1 - layer][n - 1 - j] = matrix[j][n - 1 - layer];
				matrix[j][n - 1 - layer] = top;
			}
		}

		return true;
	}

	// Rotate an array of n elements to the right by k steps.
	// For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated
	// to [5,6,7,1,2,3,4].
	public void rotate(int[] nums, int k) {
		if (k > nums.length)
			k = k % nums.length;

		int[] result = new int[nums.length];

		for (int i = 0; i < k; i++) {
			result[i] = nums[nums.length - k + i];
		}

		int j = 0;
		for (int i = k; i < nums.length; i++) {
			result[i] = nums[j];
			j++;
		}

		System.arraycopy(result, 0, nums, 0, nums.length);
	}

	public static void main(String[] args) {

	}

}
