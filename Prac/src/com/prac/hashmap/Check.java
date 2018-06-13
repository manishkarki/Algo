package com.prac.hashmap;

import java.util.HashMap;
import java.util.Map;

public class Check {
	
	public static void main(String[] args) {
		Map<Integer,Integer> check = new HashMap<>();
		check.put(2, 5);
		check.put(2, 15);
		System.out.println(check);
	}

}
