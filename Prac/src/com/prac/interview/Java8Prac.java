package com.prac.interview;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Manish Karki
 * 
 */

public class Java8Prac {

	public static void main(String [] args) 
	    {
		ExecutorService executorService = Executors.newFixedThreadPool(10);

		executorService.execute(new Runnable() {
		    public void run() {
		        System.out.println("Asynchronous task");
		    }
		});

		executorService.shutdown();

	}

	int a;

	public static void badMethod() {
		throw new RuntimeException();
	}

	public static Set<Character> stringToCharArr(String s) {
		Set<Character> set = new HashSet<Character>(26);
		for (Character ch : s.toCharArray())
			set.add(ch);
		return set;
	}

	// intersection of provided strings ,refer venn diagram
	static int gemstones(String[] arr, int len) {
		Set<Character> gemChar = new HashSet<>();
		if (arr != null && len > 0) {
			gemChar = new HashSet<>(stringToCharArr(arr[0]));
			for (int i = 1; i < len; i++) {
				gemChar.retainAll(stringToCharArr(arr[i]));
			}

		}

		return (gemChar != null ? gemChar.size() : 0);
	}

	/*
	 * public static void main(String[] args) { Scanner in = new
	 * Scanner(System.in); int n = in.nextInt(); String[] arr = new String[n];
	 * 
	 * for(int arr_i = 0; arr_i < n; arr_i++){ arr[arr_i] = in.next(); } int
	 * result = gemstones(arr, arr.length); System.out.println(result);
	 * in.close(); }
	 */

}
