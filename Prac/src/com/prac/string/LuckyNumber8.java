package com.prac.string;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class LuckyNumber8 {
	List<String> output1;

	List<String> ListCombination(String str) {
		output1 = new ArrayList<>();
		return RecCombine("", str);
	}

	List<String> RecCombine(String prefix, String rest) {
		if (rest.length() == 0)
			output1.add(prefix);
		else {
			RecCombine(prefix + rest.charAt(0), rest.substring(1));
			RecCombine(prefix, rest.substring(1));

		}

		return output1;
	}

	public static void main(String args[]) {
		LuckyNumber8 ln8 = new LuckyNumber8();
		System.out.println("");
		System.out.println("");
		System.out.println("All possible combinations are :  ");
		System.out.println("");
		System.out.println("");
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		String input1 = scan.nextLine();
		String input = input1.substring(0, n);
		List<String> get = ln8.combine(input);
		System.out.println(get);
		Iterator<String> iter = get.iterator();
		int count8 = 0;
		while (iter.hasNext()) {
			try {
				int number = Integer.parseInt(iter.next());
				if (number % 8 == 0)
					count8++;
			} catch (NumberFormatException e) {
				count8 = 0;
			}
		}
		System.out.println((int) (count8 % (Math.pow(10, 9) + 7)));
		scan.close();

		/*
		 * System.out.println(ln8.combine("978"));
		 * System.out.println(ln8.combine("909"));
		 * System.out.println(ln8.combine("wxyz"));
		 */
	}

	StringBuilder output;
	List<String> abc;

	public List<String> combine(String inputstring) {
		output = new StringBuilder();
		abc = new ArrayList<>();
		return combine(0, inputstring);
	}

	private List<String> combine(int start, String inputstring) {
		for (int i = start; i < inputstring.length(); ++i) {
			output.append(inputstring.charAt(i));
			abc.add(output.toString());
			if (i < inputstring.length())
				combine(i + 1, inputstring);
			output.setLength(output.length() - 1);
		}
		return abc;
	}

}
