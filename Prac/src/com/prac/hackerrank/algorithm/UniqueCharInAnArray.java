package com.prac.hackerrank.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UniqueCharInAnArray {

	public static List<Integer> retUniqueChar(int[] input) {
		Map<Integer, Integer> hash = new HashMap<>();
		for (int i : input) {
			if (!hash.containsKey(i))
				hash.put(i, 1);
			else
				hash.put(i, hash.get(i) + 1);
		}
		List<Integer> ret = new ArrayList<>();
		for (int i : input) {
			if (hash.get(i) == 1)
				ret.add(i);
		}
		return ret;
	}

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int index = 0;
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[index] = scan.nextInt();
			index++;
		}
		scan.close();
		System.out.println(retUniqueChar(arr));
	}
}
