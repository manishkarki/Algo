package com.prac.hackerrank;

import java.util.Scanner;

public class ArrayLeftRotation {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int d = scan.nextInt();
		int[] A = new int[n];

		for (int i = 0; i < n; i++) {
			int input = scan.nextInt();
			A[(i + n - d) % n] = input;
		}
		scan.close();
		for (int i = 0; i < n; i++) {
			System.out.print(A[i] + " ");
		}

	}
}
