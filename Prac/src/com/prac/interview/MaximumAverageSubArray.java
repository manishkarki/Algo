package com.prac.interview;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Given an array consisting of n integers, find the contiguous subarray of
 * given length k that has the maximum average value. And you need to output the
 * maximum average value. Example 1: Input: [1,12,-5,-6,50,3], k = 4 Output:
 * 12.75 Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
 * 
 * 
 * @author Manish Karki
 * 
 */

public class MaximumAverageSubArray {

	// maximum average of a contiguous sub array
	public static double findMaxAverage(int[] nums, int k) {
		long sum = 0;
		for (int i = 0; i < k; i++)
			sum += nums[i];
		long max = sum;

		for (int i = k; i < nums.length; i++) {
			sum += nums[i] - nums[i - k];
			max = Math.max(max, sum);
		}

		return max * 1.0 / k;
	}

	// maximum sum in a contiguous sub array of an array
	public static int maxSubArraySum(int a[]) {
		int size = a.length;
		int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;

		for (int i = 0; i < size; i++) {
			max_ending_here = max_ending_here + a[i];
			if (max_so_far < max_ending_here)
				max_so_far = max_ending_here;
			if (max_ending_here < 0)
				max_ending_here = 0;
		}
		return max_so_far;
	}

	public static void main(String[] args) {
		System.out.println(findMaxAverage(new int[] { 1, 12, -5, -6, 50, 3 }, 4));

		Properties properties = new Properties();

		try (InputStream inputStream = new FileInputStream("src/com/prac/application.properties")) {

			properties.load(inputStream);
			System.out.println(properties.getProperty("name"));
			System.out.println(properties.getProperty("lastname"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
