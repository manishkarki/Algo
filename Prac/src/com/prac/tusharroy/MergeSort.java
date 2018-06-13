package com.prac.tusharroy;

/**
 * @author Manish Karki
 * 
 * time complexity: O(nlogn)
 * space: O(n)
 * 
 * algorithm to be followed:
 * 		sort(arr,left,middle)
 *      sort(arr,middle+1, right)
 * 		mergeHalves(arr,left,right) in sorted order
 */


public class MergeSort {

	public static void mergeSort(int [] arr){
		mergeSort(arr, new int[arr.length],0, arr.length -1);
	}

	public static void mergeSort(int [] arr, int [] temp, int left, int right){
		if(left >= right)
			return;
		
		int middle = (left + right)/2;
		mergeSort(arr,temp, left, middle);
		mergeSort(arr, temp,middle +1 , right);
		mergeHalves(arr,temp, left, right);
	}

	//merge halves once you are done
	private static void mergeHalves(int[] arr,int [] temp, int leftStart, int rightEnd) {
		int leftEnd = (leftStart + rightEnd)/2;
		int rightStart = leftEnd + 1;
		int size = rightEnd - leftStart + 1;

		int index = leftStart;
		int left = leftStart;
		int right = rightStart;

		while( left <= leftEnd && right <=rightEnd){

			if(arr[left] <= arr[right]){
				temp[index] = arr[left];
				left++;
			}else{
				temp[index] = arr[right];
				right++;
			}
			index++;
		}
		//if elements are remaining
		System.arraycopy(arr, left, temp, index, leftEnd - left + 1);
		System.arraycopy(arr, right, temp, index, rightEnd - right + 1);
		//now again copy from temporary to original array
		System.arraycopy(temp, leftStart, arr, leftStart, size);
	}

	public static void main(String [] args){
		int [] arr = {10,7,12,5,4,2,1,15,13};
		mergeSort(arr);
		for(int i = 0 ; i < arr.length; i++){
			System.out.print(arr[i]+" ");
		}
	}
}

