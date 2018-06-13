package com.prac.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Manish Karki
 * 
 */

public class ThreeSum {

	public static List<List<Integer>> threeSum(int[] arr) {
		List<List<Integer>> results = new ArrayList<>();

		Arrays.sort(arr);
		// track 2 numbers from start and one from end
		for (int i = 0; i < arr.length - 3; i++) {
			int start = i + 1;
			int end = arr.length - 1;

			// bound check
			while (start < end) {
				// perfect condition
				if (arr[i] + arr[start] + arr[end] == 0) {
					results.add(Arrays.asList(new Integer[] { arr[i], arr[start], arr[end] }));
				}
				if (arr[i] + arr[start] + arr[end] < 0) {
					start++;
				} else {
					end--;
				}
			}
		}

		return results;
	}
	
	public static List<List<Integer>> givenSum(int [] arr, int sum){
		List<List<Integer>> results = new LinkedList<>();
		
		Arrays.sort(arr);
		
		for(int i = 0; i< arr.length-3; i++){
			int start = i+1;
			int end = arr.length-1;
			
			while(start < end){
				if(arr[i] + arr[start] + arr[end] == sum)
					results.add(Arrays.asList(new Integer[]{arr[i],arr[start], arr[end]}));
				
				else if( arr[i] + arr[start]+arr[end] < sum)
					start++;
				else
					end--;
			}
		}
		
		return results;
	}

	public static void main(String[] args) {
		System.out.println(givenSum(new int[] { -1, 0, 1, 2, -1, -4 },0));
	}

}
