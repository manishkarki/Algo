package com.prac.interview;


/**
 * @author Manish Karki
 * 
 */

public class StringManipulation {
	public void reverseWords(char[] s) {
		int i = 0;
		for (int j = 0; j < s.length; j++) {
			// on finding blank character
			if (s[j] == ' ') {
				reverse(s, i, j - 1);
				i = j + 1;
			}
		}
		// reverse(s, i, s.length - 1);
		reverse(s, 0, s.length - 1);
	}

	public void reverse(char[] s, int i, int j) {
		while (i < j) {
			char temp = s[i];
			s[i] = s[j];
			s[j] = temp;
			i++;
			j--;
		}
	}

	public static void main(String[] args) {
		StringManipulation sm = new StringManipulation();
		char[] manipulate = "Manish Love I".toCharArray();
		sm.reverseWords(manipulate);
		StringBuilder sb = new StringBuilder();
		for (Character ch : manipulate) {
			sb.append(ch);
		}

		System.out.println(sb.toString());
	}
}
