package com.prac.hackerrank.algorithm;

//just a binary tree, unsorted and random data

/**
 * @author Manish Karki
 * 
 */

public class DistanceFromRootToNode {

	static int remAnagram(String str1, String str2) {
		// make hash array for both string and calculate
		// frequency of each character
		int count1[] = new int[126], count2[] = new int[126];

		// count frequency of each charcter in first string
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) != '\0') {
				System.out.println(str1.charAt(i) - 'a' + " char chain::" + str1.charAt(i)
						+ " count1[str1.charAt(i) - 'a']" + count1[str1.charAt(i) - 'a']);
				count1[str1.charAt(i) - 'a']++;
			}
		}

		// count frequency of each charcter in second string
		for (int i = 0; i < str2.length(); i++) {
			if (str2.charAt(i) != '\0') {
				System.out.println(str2.charAt(i) - 'a' + " dosro string ma char chain::" + str2.charAt(i));
				count2[str2.charAt(i) - 'a']++;
			}
		}

		// traverse count arrays to find number of charcters
		// to be removed
		int result = 0;
		for (int i = 0; i < 26; i++)
			result += Math.abs(count1[i] - count2[i]);
		return result;
	}

	static int countSubstringWithEqualEnds(String s) {
		int result = 0;
		int n = s.length();

		// Calculating frequency of each character
		// in the string.
		int count[] = new int[26];
		for (int i = 0; i < n; i++)
			count[s.charAt(i) - 'a']++;

		// Computing result using counts
		for (int i = 0; i < 26; i++) {
			System.out.println("count[i]:"+count[i]+" result::"+result);
			result += (count[i] * (count[i] + 1) / 2);
			System.out.println("\t"+result);
		}
		return result;
	}

	public int Pathlength(Node root, int n1) {

		if (root != null) {
			int x = 0;
			if ((root.data == n1) || (x = Pathlength(root.left, n1)) > 0 || (x = Pathlength(root.right, n1)) > 0) {
				return x + 1;

			}
			return 0;
		}
		return 0;

	}

	public static void main(String[] args) throws java.lang.Exception {
		/*
		 * Node root = new Node(5); root.left = new Node(10); root.right = new
		 * Node(15); root.left.left = new Node(20); root.left.right = new
		 * Node(25); root.right.left = new Node(30); root.right.right = new
		 * Node(35); root.left.right.right = new Node(45);
		 * DistanceFromRootToNode i = new DistanceFromRootToNode();
		 * System.out.println("Distance from root to 45 is : " +
		 * (i.Pathlength(root, 45) - 1));
		 */

		System.out.println(countSubstringWithEqualEnds("abcab"));
	}
}

class Node {
	int data;
	Node left;
	Node right;

	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
