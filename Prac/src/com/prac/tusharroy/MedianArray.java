package com.prac.tusharroy;

/**
 * @author Manish Karki
 * 
 */

public class MedianArray {
	
	public static int findMedian(int [] arr1, int [] arr2, int n){
		int m1 = -1, m2 = -1;
		int i = 0, j = 0;
		
		for(int count = 0 ; count <= n; count++){
			//if all the elements in arr1 are smaller than the smallest element in arr2
			if(i == n){
				m1 = m2;
				m2 = arr2[0];
				break;
			}else if(j == n){
				m1 = m2;
				m2 = arr1[0];
				break;
			}
			
			if(arr1[i] < arr2[j]){
				m1 = m2;
				m2 = arr1[i];
				i++;
			}else{
				m1 = m2;
				m2 = arr2[j];
				j++;
			}
		}
		
		return (m1 + m2)/2;
	}
	
	public static void main(String[] args) {
		System.out.println(findMedian(new int[]{1, 12, 15, 26, 38}, new int[]{2, 13, 17, 30, 45}, 5));
	}

}
