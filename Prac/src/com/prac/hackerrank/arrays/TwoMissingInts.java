package com.prac.hackerrank.arrays;

/**
 * @author Manish Karki
 * 
 */

public class TwoMissingInts {
	
//provided an array as input that must have contain numbers from 1 to n misses two numbers, WAP to find those two
	public static int[] twoMissingNumbers(int[] arr) {
		int len = arr.length + 2;
		// 1 + 2 + ... + N-1 + N = N * (N + 1) / 2
		int totalSum = len * (len + 1) / 2;
		int arrSum = 0;
		// Sum up the input array
		for (int i :arr) {
			arrSum += i;
		}
		// totalSum - arrSum = the sum of the two results. Therefore we know 
	    // that since our two results are not equal, one result is
	    // > (sum of two results) / 2 and the other is 
	    // < (sum of two results) / 2
		int pivot = (totalSum - arrSum)/2;
		
		int totalLeftXor = 0;
		int arrLeftXor = 0;
		int totalRightXor = 0;
		int arrRightXor = 0;
		
		for (int i = 1; i <= pivot; i++) {
			totalLeftXor ^= i;
		}

		for (int i = pivot + 1; i <= len; i++) {
			totalRightXor ^= i;
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] <= pivot)
				arrLeftXor ^= arr[i];
			else
				arrRightXor ^= arr[i];
		}

		return new int[] { totalLeftXor ^ arrLeftXor, totalRightXor ^ arrRightXor };
	       
	}

	public static void main(String[] args) {
		int [] result = twoMissingNumbers(new int[]{2,4,1,7,6});
		for(int i =  0 ; i< result.length; i++){
			System.out.print(result[i]+" ");
		}
	}

}
