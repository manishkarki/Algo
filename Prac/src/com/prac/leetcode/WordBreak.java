package com.prac.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Manish Karki
 * 
 */

public class WordBreak {

	static boolean checkWordBreak(String str, Set<String> arr) {
		if (str == null && arr == null)
			return true;
		if (str != null && arr == null || str == null && arr != null)
			return false;

		int[] pos = new int[str.length() + 1];
		Arrays.fill(pos, -1);
		pos[0] = 0;

		for (int i = 0; i < str.length(); i++) {
			if (pos[i] != -1) {
				for (int j = i + 1; j <= str.length(); j++) {
					String sub = str.substring(i, j);
					// System.out.println("\ti:" + i + " " + sub);
					if (arr.contains(sub)) {
						// System.out.println("true and sub is:"+sub +"j:"+j+"
						// i:"+i);
						pos[j] = i;
					}

				}
			}
		}
		for (int i = 0; i <= str.length(); i++)
			System.out.println(pos[i]);
		return pos[str.length()] != -1;

	}

	/*
	 * Given a string s and a dictionary of words dict, add spaces in s to
	 * construct a sentence where each word is a valid dictionary word. Return
	 * all such possible sentences. For example, given s = "catsanddog", dict =
	 * ["cat", "cats", "and", "sand", "dog"], the solution is ["cats and dog",
	 * "cat sand dog"].
	 */

	@SuppressWarnings("unchecked")
	public static List<String> wordBreak(String s, Set<String> wordDict) {
	    ArrayList<String> [] pos = new ArrayList[s.length()+1];
	    pos[0]=new ArrayList<String>();
	 
	    for(int i=0; i<s.length(); i++){
	        if(pos[i]!=null){
	            for(int j=i+1; j<=s.length(); j++){
	                String sub = s.substring(i,j);
	                if(wordDict.contains(sub)){
	                    if(pos[j]==null){
	                        ArrayList<String> list = new ArrayList<String>();
	                        list.add(sub);
	                        pos[j]=list;
	                    }else{
	                        pos[j].add(sub);
	                    }
	 
	                }
	            }
	        }
	    }
	 
	    if(pos[s.length()]==null){
	        return new ArrayList<String>();
	    }else{
	        ArrayList<String> result = new ArrayList<String>();
	        dfs(pos, result, "", s.length());
	        return result;
	    }
	}
	 
	public static void dfs(ArrayList<String> [] pos, ArrayList<String> result, String curr, int i){
	    if(i==0){
	        result.add(curr.trim());
	        return;
	    }
	 
	    for(String s: pos[i]){
	        String combined = s + " "+ curr;
	        dfs(pos, result, combined, i-s.length());
	    }
	}

	public static void main(String[] args) {

		Set<String> input = new HashSet<>();
		input.add("cat");
		input.add("cats");
		input.add("sand");
		input.add("and");
		input.add("dog");
		System.out.println(wordBreak("catsanddog", input));
	}

}
