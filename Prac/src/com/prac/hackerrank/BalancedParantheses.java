package com.prac.hackerrank;

import java.util.Stack;

/**
 * 
 * check for the given input String, if the match for open and closing parentheses is found or not
 * 
 * @author Manish Karki
 *
 * Jul 4, 2017
 */
public class BalancedParantheses {

	static char[][] parenthesesGroup = { { '(', ')' }, { '{', '}' }, { '[', ']' } };

	private static boolean isBalancedExpression(String expression) {
		Stack<Character> keepOpeningParantheses = new Stack<>();
		for (char check : expression.toCharArray()) {
			if (isOpeningParanthese(check))
				keepOpeningParantheses.push(check);
			else {
				// check if there is nothing on openingPrantheses stack or the
				// char(closing one) doesn't match the subsequent
				if (keepOpeningParantheses.isEmpty() || !matchesOpenAndClose(keepOpeningParantheses.pop(), check))
					return false;
			}
		}
		return keepOpeningParantheses.isEmpty();
	}

	static char[] grp = { '(', ')' };

	private static int countRequiredChars(String input){
		
		Stack<Character> keepOpening = new Stack<>();
		int count = 0;
		
		for( char ch: input.toCharArray()){
			if(grp[0] == ch)//check if opening
				keepOpening.push(ch);
			else{//if not 
				if(keepOpening.isEmpty()){//check if stack do have something or not, if not increment count
					count++;
				}else if(!checkOpenAndClose(keepOpening.pop(), ch))// if stack is not empty, check for match, if doesn't match, again increment
					count++;
					
			}
		}
		return keepOpening.isEmpty()?count: count+ keepOpening.size();// stack can still have some , so check
	}

	private static boolean checkOpenAndClose(char top, char check) {
		if (grp[0] == top && grp[1] == check)
			return true;
		return false;
	}

	private static boolean matchesOpenAndClose(char top, char check) {
		for (char[] checkIf : parenthesesGroup) {
			if (checkIf[0] == top && checkIf[1] == check)
				return true;
		}
		return false;
	}

	private static boolean isOpeningParanthese(char check) {
		for (char[] checkIf : parenthesesGroup) {
			if (checkIf[0] == check)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(isBalancedExpression("{)"));
		System.out.println(countRequiredChars("))))(((("));
	}

}
