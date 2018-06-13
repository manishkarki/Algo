package com.prac.hackerrank.algorithm;

import java.util.Scanner;

public class ShuffleDeckAndSmallestNumberToMultiply {

	public static int[] shuffleDeck(int[] cards, int i) {
		if (i == 0)
			return cards;
		shuffleDeck(cards, i - 1);
		int rand = rand(0, i);

		int temp = cards[rand];
		cards[rand] = cards[i];
		cards[i] = temp;
		return cards;
	}

	private static int rand(int i, int i2) {
		return i2 + (int) Math.random() * (i2 - i + 1);
	}

	//--------smallest number to multiply to a numeric input to get an integer
	public static double smallestNumberToMultiply(String input) {
		int countAfterDot = 0;
		int len = input.length();
		int num = 0;
		boolean hasDot = false;
		for (int i = 0; i < len; i++) {
			if (input.charAt(i) != '.') {
				num = num * 10 + (input.charAt(i) - '0');
				if (hasDot)
					countAfterDot++;
			} else
				hasDot = true;
		}

		if (!hasDot)
			return 1;

		double denum = Math.pow(10, countAfterDot);

		return denum / gcd(num, denum);
	}

	private static double gcd(double num, double denum) {
		if (denum == 0)
			return num;
		return gcd(denum, num % denum);
	}
	
	public static int addWithoutPlus(int a , int b){
		if(b == 0)
			return a;
		if(a == 0)
			return b;
		int sum = a^b;
		int carry = (a & b) << 1;
		System.out.println("carry:"+carry+"sum here is:"+sum);
		a = sum ;
		b = carry;
		return addWithoutPlus(a, b);
	}

	public static void main(String[] args) {
		ShuffleDeckAndSmallestNumberToMultiply shd = new ShuffleDeckAndSmallestNumberToMultiply();
		Scanner scan = new Scanner(System.in);
		String input = scan.next();
		System.out.println(smallestNumberToMultiply(input));
		scan.close();
		System.out.println(shd.getClass().getName());
		System.out.println(addWithoutPlus(710, 423));

	}

}
