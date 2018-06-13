package com.prac.hackerrank.string;

/**
 * @author Manish Karki
 * 
 */

public class Palindrome {

	private static int reverse(int num) {
		int res = 0;
		while (num != 0) {
			res = (res * 10) + (num % 10);
			num = num / 10;
		}
		return res;
	}

	public static boolean isPalindrome(int num) {
		if (num < 0) return false;
		return num == reverse(num);
	}
	
	public static void main(String[] args) {
		System.out.println(isPalindrome(2147483647));
	}
}
