package com.prac.hackerrank.algorithm;

import java.util.Scanner;

public class BeautifulDaysAtMovies {

	public static void printBeautifulDaysCount() {
		Scanner scan = new Scanner(System.in);
		int i = scan.nextInt();
		int j = scan.nextInt();
		int k = scan.nextInt();

		scan.close();
		int[] days = new int[j - i + 1];
		int index = 0;
		for (int x = i; x <= j; x++) {
			days[index++] = x;
		}
		int n = days.length;
		int[] reverseDays = new int[n];
		for (int m = 0; m < n; m++) {
			reverseDays[m] = reverseElement(days[m]);
		}

		int posCount = 0;
		for (int p = 0; p < n; p++) {
			double doubQuo = Math.abs(days[p] - reverseDays[p]) / (double) k;
			int intQuo = Math.abs(days[p] - reverseDays[p]) / k;
			if (doubQuo == intQuo)
				posCount++;
		}
		System.out.println(posCount);
	}

	private static int reverseElement(int day) {
		int returnDay = 0;
		do {
			int rem = day % 10;
			day = day / 10;
			returnDay = 10 * returnDay + rem;
		} while (day != 0);
		return returnDay;
	}

	public static void printNumberIdOfPrisoner() {
		System.out.println("********Poisonous sweet receiver id*****************");
		Scanner scan = new Scanner(System.in);
		int testCases = scan.nextInt();
		while (testCases > 0) {
			int n = scan.nextInt();
			int sweets = scan.nextInt();
			int startId = scan.nextInt();
			long poisoned = (startId + sweets - 1) % n;
			if (poisoned == 0)
				poisoned = n;
			System.out.println(poisoned);
		}
		scan.close();
	}

	public static void main(String[] args) {
		// printBeautifulDaysCount();
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();
		System.out.println("no of likes:" + noOfLikes(n, 5));
	}

	private static int noOfLikes(int n, int i) {
		int like = (int) Math.floor(i / 2);
		if (n == 1)
			return like;
		int shared = like * 3;
		return noOfLikes(n - 1, shared) + like;
	}

}
