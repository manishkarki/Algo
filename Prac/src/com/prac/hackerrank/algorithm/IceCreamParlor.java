package com.prac.hackerrank.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Manish Karki
 * 
 */

public class IceCreamParlor {
	
	//find the indices of two items on the menu that we can buy with our money
	static int [] findChoices(int[] menu, int money){
		
		int [] sortedMenu = menu.clone();
		Arrays.sort(sortedMenu);
		
		for( int i = 0; i< sortedMenu.length; i++){
			int complement = money - sortedMenu[i];
			int location = Arrays.binarySearch(sortedMenu, i+1, sortedMenu.length, complement);
			
			if(location >= 0 && location < sortedMenu.length && sortedMenu[location] == complement){
				int [] indices = getIndicesOf(menu, sortedMenu[i], complement);
				return indices;
			}
		}
		return null;
	}
	
	private static int[] getIndicesOf(int[] menu, int i, int complement) {
		int index = indexOf(menu, i,-1);
		int index1 = indexOf(menu, complement, index);
		return new int[]{Math.min(index, index1), Math.max(index, index1)};
	}

	private static int indexOf(int[] menu, int value, int exclude) {
		for(int i = 0; i< menu.length; i++){
			if(menu[i] == value && i != exclude)
				return i;
		}
		return -1;
	}
	
	public static int[] twoSum(int[] numbers, int target) {
	    int[] result = new int[2];
	    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for (int i = 0; i < numbers.length; i++) {
	        if (map.containsKey(target - numbers[i])) {
	            result[1] = i + 1;
	            result[0] = map.get(target - numbers[i]);
	            return result;
	        }
	        map.put(numbers[i], i + 1);
	    }
	    return result;
	}

	public static int matrixProduct(int[][] matrix) {
	    if (matrix.length == 0 || matrix[0].length == 0) return 0;
	        
	    // Create cache of min and max product to a given cell
	    int[][] maxCache = new int[matrix.length][matrix[0].length];
	    int[][] minCache = new int[matrix.length][matrix[0].length];
	        
	    // Fill caches. We start at the top  left and iteratively find the greatest
	    // at smallest path to each subsequent cell by considering the greatest and
	    // smallest path to the cells above and to the left of the current cell
	    for (int i = 0; i < matrix.length; i++) {
	        for (int j = 0; j < matrix[0].length; j++) {
	        	 // If in the top left corner, just copy to cache
	        	if(i == 0 && j == 0){
	        		maxCache[i][j] = matrix[i][j];
	        		minCache[i][j] = matrix[i][j];
	        		continue;
	        	}
	            int maxVal = Integer.MIN_VALUE;
	            int minVal = Integer.MAX_VALUE;
	               
	            // If we're not at the top, consider the value above
	            if (i > 0) {
	                int tempMax = Math.max(matrix[i][j] * maxCache[i-1][j], matrix[i][j] * minCache[i-1][j]);
	                maxVal = Math.max(tempMax, maxVal);
	                int tempMin = Math.min(matrix[i][j] * maxCache[i-1][j], matrix[i][j] * minCache[i-1][j]);
	                minVal = Math.min(tempMin, minVal);
	            }
	            // If we're not on the left, consider the value to the left
	            if (j > 0) {
	                int tempMax = Math.max(matrix[i][j] * maxCache[i][j-1], matrix[i][j] * minCache[i][j-1]);
	                maxVal = Math.max(tempMax, maxVal);
	                int tempMin = Math.min(matrix[i][j] * maxCache[i][j-1], matrix[i][j] * minCache[i][j-1]);
	                minVal = Math.min(tempMin, minVal);
	            }
	            maxCache[i][j] = maxVal;
	            minCache[i][j] = minVal;
	        }
	    }
	        
	    // Return the max value at the bottom right
	    return maxCache[maxCache.length - 1][maxCache[0].length - 1];
	}
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
//		twoSum(new int[]{3,2,4}, 6);
		System.out.println(matrixProduct(new int[][]{{-1,2,3},{4,5,-6},{7,8,9}}));
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println("elapsed::"+elapsedTime);
	}

}
