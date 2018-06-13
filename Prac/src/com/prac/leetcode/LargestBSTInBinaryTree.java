package com.prac.leetcode;

/**
 * @author Manish Karki
 * 
 */

public class LargestBSTInBinaryTree {
	
	public class MinMax{
		boolean isBST;
		int min;
		int max;
		int size;
		
		MinMax(){
	        min = Integer.MAX_VALUE;
	        max = Integer.MIN_VALUE;
	        isBST = true;
	        size = 0;
	    }
	}
	
	public int largest(TreeNode root){
		MinMax m = largestUtil(root);
		return m.size;
	}
	
	private MinMax largestUtil(TreeNode root){
		if(root ==  null)
			return new MinMax();
		
		MinMax left = largestUtil(root.left);
		MinMax right = largestUtil(root.right);
		
		MinMax m = new MinMax();
		
		if(!left.isBST || !right.isBST || (left.max > root.data || right.min <= root.data)){
			m.isBST = false;
			m.size = Math.max(left.size, right.size);
			return m;
		}
		
		m.isBST = true;
		m.size = left.size + right.size +1;
		m.min = left != null ? left.min:root.data;
		m.max = left != null ? right.max:root.data;
		
		return m;
	}
	

}
