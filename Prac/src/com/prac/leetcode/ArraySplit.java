package com.prac.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Manish Karki
 * 
 */

public class ArraySplit {
	
	//Given a sorted array and a number k that denotes the bucket, split the array into those two buckets with near sum
	public static List<List<Integer>> arraySplit(int[] arr, int k) {
		List<List<Integer>> res = new ArrayList<>();
		int i = 0;
		for (i = arr.length - 1; i >= (arr.length - k); i--) {
			List<Integer> temp = new ArrayList<>();
			temp.add(arr[i]);
			res.add(temp);
		}
		// int c = 0;
		while (i >= 0) {
			System.out.println(res);
			//add the next number coming from the array to the result's element(list) with minm sum among all 
			int c = getListIndexWithMinSum(res);
			System.out.println("c:"+c+" when i:"+i);
			res.get(c).add(arr[i]);
			i--;
		}
		return res;
	}

	private static int getListIndexWithMinSum(List<List<Integer>> arr) {
		int minIndex = 0;
		int minSum = Integer.MAX_VALUE;
		int i = 0;
		for (List<Integer> l : arr) {
			int currSum = sum(l);
			if (minSum > currSum) {
				minSum = currSum;
				minIndex = i;
			}
			i++;
		}
		return minIndex;
	}

	private static int sum(List<Integer> arr) {
		int sum = 0;
		for (int n : arr) {
			sum += n;
		}
		return sum;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 3, 6, 9, 10 };
		List<List<Integer>> res = arraySplit(arr, 2);
		for (List<Integer> l : res) {
			System.out.println(l);
		}
	}

}
