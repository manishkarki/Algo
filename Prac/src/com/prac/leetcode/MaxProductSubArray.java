package com.prac.leetcode;

/**
 * @author Manish Karki
 * 
 */

public class MaxProductSubArray {
	
	public int maxProduct(int[] A) {
	    if (A.length == 0) {
	        return 0;
	    }
	    
	    int maxherepre = A[0];
	    int minherepre = A[0];
	    int maxsofar = A[0];
	    int maxhere, minhere;
	    
	    for (int i = 1; i < A.length; i++) {
	        maxhere = Math.max(Math.max(maxherepre * A[i], minherepre * A[i]), A[i]);
	        minhere = Math.min(Math.min(maxherepre * A[i], minherepre * A[i]), A[i]);
	        maxsofar = Math.max(maxhere, maxsofar);
	        maxherepre = maxhere;
	        minherepre = minhere;
	    }
	    return maxsofar;
	}
	
	public static int maxSum(int[] A) {
	    if (A.length == 0) {
	        return 0;
	    }
	    
	    int maxherepre = A[0];
	    int maxsofar = A[0];
	    int maxhere;
	    
	    for (int i = 1; i < A.length; i++) {
	        maxhere = Math.max(maxherepre + A[i], A[i]);
	        System.out.println();
	        maxsofar = Math.max(maxhere, maxsofar);
	        maxherepre = maxhere;
	    }
	    return maxsofar;
	}
	
	public static int findMissingNumber(int [] a, int n){
		
		int requiredSum = n*(n+1)/2;
		int sum =0;
		
		for( int i = 0; i< a.length; i++){
			sum += a[i];
		}
		
		return requiredSum - sum;
	}
	
	public static int findMissingUsingXor(int [] a, int n){
		
		int requiredSum = 0;
		
		for(int i = 1; i <= n; i++){
			requiredSum ^= i;
		}
		int sum = 0;
		
		for(int i = 0 ; i < a.length; i++){
			sum ^= a[i];
		}
		
		return requiredSum ^ sum;
	}
	
	public static void main(String[] args) {
		System.out.println(maxSum(new int[]{5, -4, 9, -1000, 3}));
		System.out.println("xor::"+findMissingUsingXor(new int[]{2,1,5,4,3,7,8}, 8));
		System.out.println(findMissingNumber(new int[]{2,1,5,4,3,7,8}, 8));
	}

}
