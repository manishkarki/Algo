package com.prac.hackerrank.algorithm;

import java.util.Scanner;

public class Solution {

    private StringBuilder output = new StringBuilder();
    private final String inputstring;
    long count = 0;
    
    Solution(final String str){
        inputstring = str;
        combine(0);
        System.out.println(count % 1000000007);
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        // your code goes here
        String s = in.next();
        String input = s.substring(0,n);
        new Solution(input);
        in.close();
    }
    
    private void combine(int start ) throws NumberFormatException{
        for( int i = start; i < inputstring.length(); ++i ){
            output.append( inputstring.charAt(i) );
            long num = Long.parseLong(output.toString());
            if(num % 8 == 0) {
            	count++;
            	count = count % 1000000007;
            }
            if ( i < inputstring.length() )
            combine( i + 1);
            output.setLength( output.length() - 1 );//output.substring(0, output.length());
        }
    }
}

