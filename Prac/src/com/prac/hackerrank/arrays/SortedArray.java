package com.prac.hackerrank.arrays;


/**
 * @author Manish Karki
 * 
 */

public class SortedArray {
	
	/*Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
	Do not allocate extra space for another array, you must do this in place with constant memory.
	For example,Given input array nums = [1,1,2],Your function should return length = 2, with the first two elements of nums being 1 and
	2 respectively.
	It doesn't matter what you leave beyond the new length.
	*/
	public static int removeDuplicates(int[] nums) {
        return removeDuplicates(nums, nums.length);
    }
    
    private static int removeDuplicates(int []arr, int n){
        if(n < 2)
            return n;
        int index = 1;
        for(int i = 1; i < n; i++){
            if( arr[i] != arr[i-1]){
                arr[index++] = arr[i];
                System.out.println("index:"+index+" "+arr[index]);
            }
        }
        
        return index;
    }
    
    /*Given a sorted array consisting of only integers where every element appears twice except for one element which appears once.
     *  Find this single element that appears only once.
    Example 1:
    Input: [1,1,2,3,3,4,4,8,8]
    Output: 2*/
    
    public static int singleNonDuplicate(int[] nums) {
        // binary search
        int n = nums.length, low = 0, high = n/2;
        while (low < high) {
            int m = (low + high) / 2;
            if (nums[2*m]!=nums[2*m+1])
            	high = m;
            else 
            	low = m+1;
        }
        return nums[2*low];
    }
    
    public static void main(String[] args) {
		System.out.println(removeDuplicates(new int[]{1,2,2}));
//		System.out.println(singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}));
	}

}
