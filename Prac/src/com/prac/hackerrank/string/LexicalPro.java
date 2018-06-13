package com.prac.hackerrank.string;

import java.util.Scanner;

/*Given a string, find out the lexicographically smallest and largest substring of length .

[Note: Lexicographic order is also known as alphabetic order dictionary order. So "ball" is smaller than "cat", "dog" is 
 smaller than "dorm". Capital letter always comes before smaller letter, so "Happy" is smaller than "happy" and "Zoo" is smaller
 than "ball".]*/

public class LexicalPro {

	public static boolean checkPalindrome(String A){
		int len = A.length();
		
        for(int i = 0; i < len; i++){
                if(A.charAt(i) != A.charAt(len-1-i))
                    return false;
        }
        return true;
    }
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		int k = scan.nextInt();
		scan.close();

		int t = input.length() - k + 1;
		String[] s1 = new String[t];

		for (int i = 0; i < t; i++) {
			s1[i] = input.substring(i, i + k);
		}
		for (int i = 0; i < t; i++)
			System.out.println("Subsets are::" + s1[i]);
		String smallest = s1[0];
		String largest = smallest;
		for (int i = 1; i < t; i++) {
			if (s1[i].compareTo(smallest) < 0) {
				smallest = s1[i];
			}
			if (s1[i].compareTo(largest) > 0) {
				largest = s1[i];
			}
		}

		System.out.println(smallest);
		System.out.println(largest);
		boolean check = checkPalindrome(input);
        System.out.println(check?"Yes":"No");

	}

}
