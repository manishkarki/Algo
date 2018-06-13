package com.prac.hackerrank;

import java.util.*;

public class DynamicArray {
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner scan = new Scanner(System.in);
		int numSeq = scan.nextInt();
		int numQueries = scan.nextInt();

		int lastAns = 0, x, y, tag, index;

		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] list = new ArrayList[numSeq];

		while (numQueries --> 0) {
			tag = scan.nextInt();
			x = scan.nextInt();
			y = scan.nextInt();
			index = (x ^ lastAns) % numSeq;

			switch (tag) {

			case 1:
				if (list[index] == null) {
					ArrayList<Integer> myList = new ArrayList<>();
					myList.add(y);
					list[index] = myList;
				} else
					list[index].add(y);
				break;
			case 2:
				lastAns = list[index].get(y% list[index].size());
				System.out.println("lastAns =" + list[index].get(y % list[index].size()));
				break;
			}
		}
		scan.close();
	}
}
