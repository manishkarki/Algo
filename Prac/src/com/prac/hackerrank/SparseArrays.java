package com.prac.hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SparseArrays {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int N = Integer.parseInt(scan.nextLine());
        Map<String,Integer> stringHashMap = new HashMap<>();
        
        while(N --> 0){
            String input = scan.nextLine();
            if(stringHashMap.containsKey(input))
                stringHashMap.put(input, stringHashMap.get(input)+1);
            else
                stringHashMap.put(input,1);
        }
        
        System.out.println(stringHashMap.toString());
        
        int numQueries = Integer.parseInt(scan.nextLine());
        
        while(numQueries --> 0){
            String query = scan.nextLine();
            if(stringHashMap.containsKey(query))
                System.out.println(stringHashMap.get(query));
            else
                System.out.println("0");
        }
        scan.close();
    }
}
