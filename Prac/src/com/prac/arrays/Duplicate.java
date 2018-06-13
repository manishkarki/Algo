package com.prac.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * The set S originally contains numbers from 1 to n. But unfortunately, due to the data error, one of the numbers in the set got duplicated
	to another number in the set, which results in repetition of one number and loss of another number.
	
	Given an array nums representing the data status of this set after the error. Your task is to firstly find the number occurs twice
	and then find the number that is missing. Return them in the form of an array.
	
	Example 1:
	Input: nums = [1,2,2,4]
	Output: [2,3]
 * 
 * @author Manish Karki
 * 
 */




public class Duplicate {
	
	/*public static String compare(int num1, int num2){
		int result = num1 - num2;
		
		if(result > 0)
			return "num1 is greater than num2";
		else if( result < 0)
			return "num2 is greater than num1";
		
		return "num1 and num2 are equal";
	}
	*/
	public static int[] findErrorNums(int[] nums) {
		int n = nums.length;
		int sum = n*(n+1)/2;
		Set<Integer> set = new HashSet<>();
		int dup = 0;
		
		for(int i = 0 ; i < nums.length; i++){
			if(set.contains(nums[i]))
				dup = nums[i];
			sum -= nums[i];
			set.add(nums[i]);
		}
		
		System.out.println(sum+" is remaining");
		return new int[]{dup, sum + dup};

	}
	
	public static void main(String[] args) {
		int [] result = findErrorNums(new int[]{1,2,2,4});
		for( int a: result)
			System.out.println(a);
	}

}
