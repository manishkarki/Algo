package com.prac.hackerrank.string;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Anagrams {

	static boolean isAnagram(String a, String b) {
		int lenA = a.length();
		int lenB = b.length();

		if (lenA != lenB)
			return false;

		Map<Character, Integer> occurence = new HashMap<>();

		for (int i = 0; i < lenA; i++) {
			// System.out.println(occurence.get(a.charAt(i)));
			if (occurence.get(a.charAt(i)) == null)
				occurence.put(a.charAt(i), 1);
			else
				occurence.put(a.charAt(i), occurence.get(a.charAt(i)) + 1);
		}

		for (int i = 0; i < lenA; i++) {
			// System.out.println(occurence.get(a.charAt(i)));
			if (occurence.get(b.charAt(i)) == null)
				return false;
			else
				occurence.put(b.charAt(i), occurence.get(b.charAt(i)) - 1);
		}

		Iterator<Entry<Character, Integer>> it = occurence.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Character, Integer> pair = (Entry<Character, Integer>) it.next();
			System.out.println(pair.getKey() + " = " + pair.getValue());
			if (pair.getValue() != 0)
				return false;
		}

		/* another way to traverse through a Map */

		for (Character index : occurence.keySet()) {
			if (occurence.get(index) != 0)
				return false;
		}

		return true;

	}

	public static void main(String[] args) {
		System.out.println(isAnagram("anagramm", "marganaa"));
		StringTokenizer st = new StringTokenizer("He is a very very good boy, isn't he?", " !,?._'@");
		System.out.println(st.countTokens());
		/*double a = 'a';
		char a1 = 100;*/
		
		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}
}
