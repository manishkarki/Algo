package com.prac.hackerrank.algorithm;

import java.util.*;

public class Compare {
	
	public static void printPattern(int n, String pattern){
		StringBuilder sb =new StringBuilder();
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                sb.append(pattern);
            }
            System.out.printf("%"+n+"s",sb.toString());
            sb.delete(0,sb.length());
            System.out.println();
        }
	}
	
	public static void printConverted12HrDateTo24HrFormat(String in){
		char[] inputChar = in.toCharArray();
	    char[] out = Arrays.copyOfRange(inputChar, 0, 8);
		if(inputChar[8] == 'A' && in.substring(0,2).intern().equals("12")) {
		    out[0] = '0';
		    out[1] = '0';
		}
		else if(inputChar[8] =='P' && !in.substring(0,2).intern().equals("12")) {
		    String s = "" + (Integer.parseInt(in.substring(0,2)) + 12);
		    char[] f = s.toCharArray();
		    out[0] = f[0];
		    out[1] = f[1];
		}
		System.out.println(out);
	}
	
	public static void comparePoints(){
		Scanner in = new Scanner(System.in);
        int a0 = in.nextInt();
        int a1 = in.nextInt();
        int a2 = in.nextInt();
        int b0 = in.nextInt();
        int b1 = in.nextInt();
        int b2 = in.nextInt();
        
        in.close();
        int pointsAlice = ((a0>b0)?1:0)+ ((a1>b1)?1:0)+ ((a2>b2)?1:0) ;
        int pointsBob = ((a0<b0)?1:0)+ ((a1<b1)?1:0)+ ((a2<b2)?1:0) ;
        System.out.println(pointsAlice+" " +pointsBob);
	}
	
	public static void computeDifferenceOfDiagonals(){
		Scanner in1 = new Scanner(System.in);
        int n = in1.nextInt();
        int arr[][] = new int[n][n];
        for(int arr_i=0; arr_i < n; arr_i++){
            for(int arr_j = 0; arr_j < n; arr_j++){
            	arr[arr_i][arr_j] = in1.nextInt();
            }
        }
        
        in1.close();
        int sum1 = 0, sum2 = 0;
        for(int i = 0; i<arr.length; i++){
        	for(int j = 0; j<arr[i].length; j++){
        		if(i == j)
        			sum1 +=arr[i][j];
        		if((i+j)== n-1)
        			sum2 += arr[i][j];
        	}
        }
        System.out.println(Math.abs(sum1-sum2));
	}

    public static void main(String[] args) {
    	
    	printPattern(20, "m");
    	printConverted12HrDateTo24HrFormat("07:05:45PM");
    	
    }
}

