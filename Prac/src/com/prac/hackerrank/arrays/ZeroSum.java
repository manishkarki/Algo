package com.prac.hackerrank.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Manish Karki
 * 
 */

public class ZeroSum {
	/*
	 * Given an array, write a function to find any subarray that sums to zero,
	 * if one exists.
	 * 
	 * eg.
	 * 
	 * zeroSum({1, 2, -5, 1, 2, -1}) = [2, -5, 1, 2]
	 */
	public static int[] zeroSum(int[] arr) {
	    Map<Integer, Integer> sums = new HashMap<Integer, Integer>();
	 
	    int sum = 0;
	    for (int i = 0; i <= arr.length; i++) {
	        Integer oldIndex = sums.get(sum);
	        if (oldIndex == null && i == arr.length) {
	            return null;
	        } else if (oldIndex == null) {
	            sums.put(sum, i);
	            sum += arr[i];
	        } else {
	            return Arrays.copyOfRange(arr, oldIndex, i);
	        }
	    }
	 
	    return null;
	}
	
	public static void main(String[] args) {
		int [] resultzeroSum = zeroSum(new int[]{1,2,-5,1,2,-1});
		for(int i = 0; i< resultzeroSum.length; i++){
			System.out.print(resultzeroSum[i]);
		}
	}

}
