package com.prac.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Java Program to find all permutations of a String
 * 
 * @author Manish
 *
 */
public class StringHelper {
	public static Set<String> permutationFinder(String str) {
		Set<String> perm = new HashSet<String>();
		// Handling error scenarios
		if (str == null) {
			return null;
		} 
		if (str.length() == 0) {
			perm.add("");
			return perm;
		}
		char initial = str.charAt(0); // first character
		String rem = str.substring(1); // Full string without first character
		System.out.println("rem::" + rem);
		Set<String> words = permutationFinder(rem);
		System.out.println("words::" + words);
		for (String strNew : words) {
			System.out.println("strNew::" + strNew);
			for (int i = 0; i <= strNew.length(); i++) {
				perm.add(charInsert(strNew, initial, i));
				System.out.println("perm:" + perm);
			}
		}
		return perm;
	}

	public static String charInsert(String str, char c, int j) {
		String begin = str.substring(0, j);
		String end = str.substring(j);
		return begin + c + end;
	}

	//method to replace all the occurrence of pi in a string with 3.14
	public static String replacePi(String str) {
		if (str.length() < 2) {
			
				return str;
		}

		
		if (str.substring(0, 2).equals("pi")) {
			return "3.14" + replacePi(str.substring(2));
		}

		return str.charAt(0) + replacePi(str.substring(1));
	}
	
	public static List<String> getAllUniqueStringSet(String input) {
        List<String> unique = new ArrayList<String>();
        int len = input.length();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i; j++) {
                String adder = input.substring(j, j + (i+1));
                    unique.add(adder);
            }
        }
        return unique;
    }
	
	public static int countNumberOfUniqueCharacters(String input) {
	    Map<Character,Integer> set = new HashMap<>();
	    for(int i = 0; i<input.length(); i++){
	    	char c = input.charAt(i);
	    	if(set.containsKey(c))
	    		set.put(c, set.get(c)+1);
	    	else
	    		set.put(c, 1);
	    }
	    
	    int size = 0;
	    Iterator<Map.Entry<Character, Integer>> iter = set.entrySet().iterator();
	    while(iter.hasNext()){
	    	Entry<Character,Integer> entry = iter.next();
	    	if(entry.getValue() == 1)
	    		size++;
	    }
	    return size;
	}
	
	


	public static void main(String[] args) {
		String s = "AAC";
		String s1 = "aba";
		String s2 = "ABCD";
		System.out.println("\nPermutations for " + s + " are: \n" + permutationFinder(s));
		System.out.println("\nPermutations for " + s1 + " are: \n" + permutationFinder(s1));
		System.out.println("\nPermutations for " + s2 + " are: \n" + permutationFinder(s2));
		System.out.println(replacePi("pixxpi"));
		System.out.println(countNumberOfUniqueCharacters("aa"));
		/*Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        while(testCases > 0){
        	String take = scan.next();
            List<String> output = getAllUniqueStringSet(take);
            System.out.println(output);
            Iterator<String> iter = output.iterator();
            int sum = 0;
            while(iter.hasNext()){
                String get = iter.next();
                int len = get.length();
                long startTime = System.currentTimeMillis();
                int countUnique = countNumberOfUniqueCharacters(get);
                long endTime = System.currentTimeMillis();
                System.out.println("It took " + (endTime - startTime) + " milliseconds");
                sum += Math.pow(len, countUnique) %(Math.pow(10, 9)+7);
            }

            System.out.println(sum);
            
        }*/
	}
}
