package com.prac.leetcode.dp;

/**
 * @author Manish Karki
 * 
 */

public class MaximumProductCutting {
	
/*	Given a rope of length n meters, write an algo­rithm to cut the rope in such a way that prod­uct of dif­fer­ent lengths of rope
	is max­i­mum. At least one cut has to be made.
*/
	public static int maxProductByCutting(int n){
		int [] MPC = new int[n+1];
		MPC[1] = 1;
		for (int i = 2; i < n + 1; i++) {
			int mp = Integer.MIN_VALUE;
			for (int j = 1; j < i; j++) {
				mp = Math.max(mp, Math.max(j * MPC[i - j], j * (i - j)));
			}
			MPC[i] = mp;
		}
		System.out.println("Dynamic Programming: Maximum product cutting in "
				+ n + " is " + MPC[n]);
		for(int i = 0; i < n+1; i++){
			System.out.println(MPC[i]);
		}
		return MPC[n];
	}
	
	public static void main(String[] args) {
		maxProductByCutting(10);
	}
	
}
