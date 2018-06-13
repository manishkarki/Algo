package com.prac.hackerrank.algorithm;

import java.util.Scanner;

public class AngryProfessor {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t > 0) {
			int n = in.nextInt();
			int k = in.nextInt();
			int a[] = new int[n];
			for (int a_i = 0; a_i < n; a_i++) {
				a[a_i] = in.nextInt();
			}
			int rightArrivals = 0;
			for (int a_i = 0; a_i < n; a_i++) {
				if (a[a_i] <= 0)
					rightArrivals++;
			}

			if (rightArrivals >= k)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		in.close();
	}
}
