package com.prac.leetcode;

/**
 * @author Manish Karki
 * 
 */

public class RotateMatrix {
	
	private RotateMatrix(){
		
	}
	
	//Given an image represented by N*N matrix, where each pixel in the image is 4 bytes, write a method to rotate the image by 90 degrees
	
	public static boolean rotate(int [][] m){
		
		int n = m.length;
		
		if(n == 0 || n != m[0].length)
			return false;
		
		for(int layer = 0; layer< n/2; layer++){
			
			int first = layer;
			int last = n-layer-1;
			
			for(int i = first; i < last; i++){
				int offset = i - first;
				int top = m[first][i];
				//left to top
				m[first][i] = m[last- offset][first];
				//bottom to left
				m[last-offset][first] = m[last][last-offset];
				//right to bottom
				m[last][last-offset] = m[i][last];
				//top to right
				m[i][last] = top; 
			}
			
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		int [][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
		rotate(matrix);
		for(int i = 0; i< matrix.length; i++){
			for(int j = 0; j < matrix[i].length; j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	

}
