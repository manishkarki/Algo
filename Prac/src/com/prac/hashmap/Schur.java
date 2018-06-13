package com.prac.hashmap;

import java.util.*;

public class Schur {
	
	private static boolean checkForSum(List<Integer> list, int i) {
		HashMap<Integer,Boolean> check = new HashMap<Integer, Boolean>();

		Iterator<Integer> iter = list.iterator();
		while (iter.hasNext()){
			int element = iter.next();
			if (!check.containsKey(element)){
				check.put(element, true);
			}
		}
		
		System.out.println(check.toString());
		for (Integer key:check.keySet()){
			System.out.println("i-key="+(i-key));
			if (check.containsKey(i-key)){
				return check.get(key);
			}
		}
		
		return false;
	}
	
	
	public static void main(String args[]){
		
		List <Integer> list=new ArrayList<Integer>();
		
		for (int i=1;i<10;i++){
			list.add(i);
		}
		
		System.out.println("Contains Sum elements for 5: " + checkForSum(list,5));
	}
	
}

