package com.prac.leetcode;

/**
 * @author Manish Karki
 * 
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class T9 {
	private static Map<Integer, Set<Character>> getKeyMappings() {
		Map<Integer, Set<Character>> keyMappings = new HashMap<Integer, Set<Character>>();
		keyMappings.put(2, new HashSet<Character>(Arrays.asList('a', 'b', 'c')));
		keyMappings.put(3, new HashSet<Character>(Arrays.asList('d', 'e', 'f')));
		keyMappings.put(4, new HashSet<Character>(Arrays.asList('g', 'h', 'i')));
		keyMappings.put(5, new HashSet<Character>(Arrays.asList('j', 'k', 'l')));
		keyMappings.put(6, new HashSet<Character>(Arrays.asList('m', 'n', 'o')));
		keyMappings.put(7, new HashSet<Character>(Arrays.asList('p', 'q', 'r', 's')));
		keyMappings.put(8, new HashSet<Character>(Arrays.asList('t', 'u', 'v')));
		keyMappings.put(9, new HashSet<Character>(Arrays.asList('w', 'x', 'y', 'z')));
		return keyMappings;
	}

	public static Map<Integer, Set<Character>> keyMappings = getKeyMappings();

	public static Set<String> getMatches(WordTrie trie, int[] keypresses) {
		return getMatchesHelper(trie.root, keypresses, 0);
	}

	private static Set<String> getMatchesHelper(WordTrie.Node node, int[] keypresses, int i) {
		Set<String> matches = new HashSet<String>();
		if (i >= keypresses.length) {
			if (node.endOfWord)
				matches.add("");
			return matches;
		}
		int keypress = keypresses[i];
		for (char firstChar : keyMappings.get(keypress)) {
			WordTrie.Node subNode = node.get(firstChar);
			if (subNode != null) {
				Set<String> suffixes = getMatchesHelper(subNode, keypresses, i + 1);
				for (String suffix : suffixes)
					matches.add("" + firstChar + suffix);
			}
		}
		return matches;
	}

	public static void main(String[] args) {
		WordTrie trie = WordTrie.fromSystemWords();
		System.out.println(getMatches(trie, new int[] { 2, 2, 5, 5 }));
		System.out.println(getMatches(trie, new int[] { 2, 2, 8 }));
		System.out.println(getMatches(trie, new int[] { 3, 6, 4 }));
		System.out.println(getMatches(trie, new int[] { 3, 2, 8, 2 }));
		System.out.println(getMatches(trie, new int[] { 7, 8, 7, 8, 2, 8, 8, 7, 3 }));
		System.out.println(getMatches(trie, new int[] { 2, 6, 6, 7, 8, 8, 3, 7 }));
		System.out.println(getMatches(trie, new int[] { 7, 2, 4, 3, 6, 2, 3 }));
	}

}

class WordTrie {
	public Node root = new Node(false);

	public static class Node extends HashMap<Character, Node> {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public boolean endOfWord;

		public Node(boolean endOfWord) {
			this.endOfWord = endOfWord;
		}
	}

	public WordTrie(Collection<String> words) {
		for (String word : words)
			add(word);
	}

	public void add(String word) {
		addHelper(root, word.toLowerCase());
	}

	private void addHelper(Node node, String word) {
		if (word.length() == 0) {
			node.endOfWord = true;
			return;
		} else {
			char first = word.charAt(0);
			String rest = word.substring(1);
			if (!node.containsKey(first))
				node.put(first, new Node(false));
			addHelper(node.get(first), rest);
		}
	}

	public static WordTrie fromSystemWords() {
		try {
			List<String> words = Files.readAllLines(Paths.get("/usr/share/dict/words"));
			return new WordTrie(words);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

}
