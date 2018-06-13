package com.prac.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Manish Karki
 * 
 */

public class Trie {

	private class TrieNode {
		private Map<Character, TrieNode> children;
		private boolean endOfWord;

		public TrieNode() {
			children = new HashMap<>();
			endOfWord = false;
		}

 		
	}

	private final TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	// insertion of word in a trie structure
	public void insert(String word) {

		TrieNode current = root;

		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);

			TrieNode node = current.children.get(ch);

			if (node == null) {
				node = new TrieNode();
				current.children.put(ch, node);
			}
			current = node;
		}
		// since all chars has been traversed
		current.endOfWord = true;

	}

	// search a word

	public boolean search(String word) {
		TrieNode current = root;

		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);

			TrieNode node = current.children.get(ch);

			if (node == null) {
				return false;
			}
			current = node;
		}
		
		return current.endOfWord;
	}

	
	public static void main(String[] args) {
		int a = 17;//00101010
		int b = 15;
		// A quick way to swap a and b
		a ^= b;
		b ^= a;
		a ^= b; 
		System.out.println(a+" "+b);
		double K = Math.log10(10);
		K = K - Math.floor(K);
		int X = (int)Math.pow(10, K);
		System.out.println(X);

	}
	
	

}
