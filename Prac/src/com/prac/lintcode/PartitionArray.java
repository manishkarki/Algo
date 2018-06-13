package com.prac.lintcode;

/**
 * @author Manish Karki
 * 
 */

public class PartitionArray {

	/*Partition an integers array into odd number first and even number second.*/
	public static void partitionArray(int[] nums) {
		if (nums == null)
			return;

		int left = 0, right = nums.length - 1;
		while (left < right) {
			// odd number
			while (left < right && nums[left] % 2 != 0) {
//				System.out.println("left"+left);
				left++;
//				System.out.println("left after increment:"+left);
			}
			// even number
			while (left < right && nums[right] % 2 == 0) {
//				System.out.println("right"+right);
				right--;
//				System.out.println("right after decrement:"+right);
			}
			// swap
			if (left < right) {
				int temp = nums[left];
				nums[left] = nums[right];
				nums[right] = temp;
				left++;
				right--;
			}
		}
	}
	
	public static void main(String[] args) {
		int [] nums = new int[]{1,21,30,4,5,6};
		partitionArray(nums);
		for(int i = 0; i< nums.length; i++){
			String indent = i < nums.length-1?" ,":"";
			System.out.print(nums[i]+indent);
		}
	}

}
