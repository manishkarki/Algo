package com.prac.hackerrank;

import java.util.Scanner;

public class BoatTrip {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	    int n = in.nextInt();
	    int c = in.nextInt();
	    int m = in.nextInt();
	    int[] p = new int[n];
	    int max = 0;
	    for(int p_i=0; p_i < n; p_i++){
	        p[p_i] = in.nextInt();
	            if(p[p_i] > max){
	            	max = p[p_i];
	            }
	    }
	    System.out.println((max <= c*m)? "Yes":"No");
	    in.close();
	}
}
