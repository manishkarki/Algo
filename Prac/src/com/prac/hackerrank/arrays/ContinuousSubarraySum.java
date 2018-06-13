package com.prac.hackerrank.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Manish Karki
 * 
 */

public class ContinuousSubarraySum {

	public static boolean checkSubarraySum(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
				put(0, -1);
			}
		};
		int runningSum = 0;
		for (int i = 0; i < nums.length; i++) {
			runningSum += nums[i];
			System.out.println("after summing elements runningSum:"+ runningSum);
			if (k != 0)
				runningSum %= k;
			System.out.println("RunningSum after modulo::"+runningSum);
			Integer prev = map.get(runningSum);
			System.out.println("map.get(runningSum):"+prev);
			if (prev != null) {
				System.out.println("i="+i+" prev:"+prev+" runningSum:"+runningSum);
				if (i - prev > 1)
					return true;
			} else
				map.put(runningSum, i);
		}
		return false;
	}
	
	public static void main(String[] args) {
		int guess = 12321;
		String temp = Integer.toString(guess);
		int[] newGuess = new int[temp.length()];
		for (int i = 0; i < temp.length(); i++)
		{
		    newGuess[i] = temp.charAt(i) - '0';
		}
		
		for(int i = 0; i< temp.length(); i++){
			System.out.println(newGuess[i]);
		}
		
		System.out.println(Integer.MIN_VALUE);
		
		System.out.println("continuous:"+checkSubarraySum(new int[]{2,2,3,7}, 7));
	}


}
