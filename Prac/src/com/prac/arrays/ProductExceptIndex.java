package com.prac.arrays;

/**
 * @author Manish Karki
 * 
 */

public class ProductExceptIndex {
	
	public static int [] getProductsOfAllIntsExceptAtIndex(int [] a){
		
		if(a.length < 2)
			throw new IllegalArgumentException("The input requires atleast two numbers");
		
		int [] productsOfAllIntsExceptAtIndex = new int[a.length];
		
		int producstSoFar = 1;
		for(int i = 0 ; i < a.length; i++){
			productsOfAllIntsExceptAtIndex[i] = producstSoFar;
			producstSoFar *= a[i];
		}
		
		producstSoFar = 1;
		for( int i = a.length - 1; i >=0 ;i--){
			productsOfAllIntsExceptAtIndex[i]*= producstSoFar;
			producstSoFar *= a[i];
		}
		
		return productsOfAllIntsExceptAtIndex;
	}
	
	public static void main(String[] args) {
		int [] a = {2};
		int [] b = getProductsOfAllIntsExceptAtIndex(a);
		
		for(int i : b){
			System.out.println(i);
		}
	}

}
