package com.prac.leetcode;

/**
 * @author Manish Karki
 * 
 */

public class TrapWater {

	/*
	Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to 
	trap after raining.
	Input: arr[]   = {2, 0, 2}
	Output: 2
	Structure is like below
	| |
	|_|
	We can trap 2 units of water in the middle gap.
	*/
	public int trap(int[] height) {

		int n = height.length;
		int[] left = new int[n];

		// Right [i] contains height of tallest bar to
		// the right of ith bar including itself
		int[] right = new int[n];

		// Initialize result
		int water = 0;

		// Fill left array
		if (n >= 1)
			left[0] = height[0];
		for (int i = 1; i < n; i++){
			left[i] = Math.max(left[i - 1], height[i]);
			System.out.print(left[i]+" ");
		}
		// Fill right array
		if (n >= 1)
			right[n - 1] = height[n - 1];
		for (int i = n - 2; i >= 0; i--){
			right[i] = Math.max(right[i + 1], height[i]);
			System.out.print(right[i]+" ");
		}

		// Calculate the accumulated water element by element
		// consider the amount of water on i'th bar, the
		// amount of water accumulated on this particular
		// bar will be equal to min(left[i], right[i]) - arr[i] .
		for (int i = 0; i < n; i++)
			water += Math.min(left[i], right[i]) - height[i];

		return water;
	}
	
	public int trap1(int[] A) {
	    if (A.length < 3) return 0;
	    
	    int ans = 0;
	    int l = 0, r = A.length - 1;
	    
	    // find the left and right edge which can hold water
	    while (l < r && A[l] <= A[l + 1]) l++;
	    while (l < r && A[r] <= A[r - 1]) r--;
	    
	    while (l < r) {
	        int left = A[l];
	        int right = A[r];
	        if (left <= right) {
	            // add volume until an edge larger than the left edge
	            while (l < r && left >= A[++l]) {
	                ans += left - A[l];
	            }
	        } else {
	            // add volume until an edge larger than the right volume
	            while (l < r && A[--r] <= right) {
	                ans += right - A[r];
	            }
	        }
	    }
	    return ans;
	}

}
