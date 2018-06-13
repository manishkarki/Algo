package com.prac.leetcode;

/**
 * @author Manish Karki
 * 
 */

public class SameFirstAndLastDigit {
	
	public static int count(int start, int end){
		return getCount(end)- getCount(start-1);
	}

	private static int getCount(int n) {
		if( n < 10)
			return n;
		int count = 9 + n/10;
		int firstDigit =  getFirstDigit(n);
		int lastDigit = n%10;
		
		if(lastDigit < firstDigit)
			count--;
		return count;
	}

	private static int getFirstDigit(int n) {
		while(n >= 10){
			n /=10;
		}
		return n;
	}
	
	public static void main(String[] args) {
		System.out.println(count(5,40));
	}

}
