package com.prac.hackerrank.string;


/**
 * @author Manish Karki
 * 
 */

public class Permutations {

	/**
	 * permutation function
	 * 
	 * @param str
	 *            string to calculate permutation for
	 * @param start
	 *            starting index
	 * @param end
	 *            end index
	 */
	private void permute(String str, int start, int end) {
		if (start == end)
			System.out.println(str);
		else {
			for (int i = start; i <= end; i++) {
				str = swap(str, start, i);
				permute(str, start + 1, end);
				str = swap(str, start, i);
			}
		}
	}

	/**
	 * Swap Characters at position
	 * 
	 * @param a
	 *            string value
	 * @param i
	 *            position 1
	 * @param j
	 *            position 2
	 * @return swapped string
	 */
	public String swap(String a, int i, int j) {
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}
	

	public static void main(String[] args) {
		String str = "ABC";
		int n = str.length();
		Permutations permutation = new Permutations();
		long startTime = System.currentTimeMillis();
		permutation.permute(str, 0, n - 1);
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println("elapsed::"+elapsedTime);
	}

}
