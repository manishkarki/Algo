package com.prac.leetcode;

/**
 * @author Manish Karki
 * 
 */

public class SingleNonDuplicate {

	public static int singleNonDuplicate(int[] nums) {
		// binary search
		int n = nums.length, low = 0, high = n / 2;
		while (low < high) {
			int m = (low + high) / 2;
			System.out.println("low:" + low + " high:" + high + " m:" + m);
			if (nums[2 * m] != nums[2 * m + 1]) {
				System.out.println("nums[2*m] != nums[2*m+1]");
				high = m;
			} else {
				low = m + 1;
				System.out.println("in else: low="+low+" high="+high);
			}
		}
		return nums[2 * low];
	}
	
	public static int singleNonDuplicate1(int[] nums) {
        //Length of the array would be odd or else the constraint fails
        int n = nums.length;
        if(n %2 != 1)
        	return -1;
        if (n == 1)
        	return nums[0];
        
        for (int i=0,j=1;i<n-1;i+=2){
            if (nums[i]!=nums[j]){
                return nums[i];
            }
            j+=2;
        }
        //ultimately return the last value
        return nums[n-1];
        
    }
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		System.out.println(singleNonDuplicate(new int[]{1,1,2,2,3,3,4,4,5}));
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println("elapsed::"+elapsedTime);
		
	}

}
