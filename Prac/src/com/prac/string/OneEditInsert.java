package com.prac.string;

/**
 * @author Manish Karki
 * 
 */

public class OneEditInsert {
	// check if a char Insertion in S1 makes it S2
	static boolean oneEditInsert(String s1, String s2) {
		int index1 = 0, index2 = 0;
		while (index1 < s1.length() && index2 < s2.length()) {
			if (s1.charAt(index1) != s2.charAt(index2)) {
				if (index1 != index2)
					return false;

				index2++;
			} else {
				index1++;
				index2++;
			}
		}
		return true;
	}

	// check if a single char is only the difference between s1 and s2
	static boolean oneEditRemove(String s1, String s2) {

		boolean foundDifference = false;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				if (foundDifference)
					return false;
				foundDifference = true;
			}

		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(oneEditInsert("ale", "bale"));
		System.out.println(oneEditRemove("pale", "bale"));
	}

}
