package com.prac.hackerrank.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubSetSum{
    // Returns true if there is a subset of set[] with sum
        // equal to given sum
	static int a = 0;
    static boolean isSubsetSum(int set[], int n, int sum)
    {
       // Base Cases
    	a++;
    	System.out.println("("+a+") sum:"+sum+" n:"+n);
       if (sum == 0)
         return true;
       if (n == 0 && sum != 0)
         return false;
      
       // If last element is greater than sum, then ignore it
       if (set[n-1] > sum)
         return isSubsetSum(set, n-1, sum);
       /* else, check if sum can be obtained by any of the following
          (a) including the last element
          (b) excluding the last element   */
       return isSubsetSum(set, n-1, sum) || 
                                   isSubsetSum(set, n-1, sum-set[n-1]);
    }
    
    static boolean isSubsetSumDynamic(int set[], int n, int sum)
    {
        // The value of subset[i][j] will be true if there 
            // is a subset of set[0..j-1] with sum equal to i
        boolean subset[][] = new boolean[sum+1][n+1];
      
        // If sum is 0, then answer is true
        for (int i = 0; i <= n; i++)
          subset[0][i] = true;
      
        // If sum is not 0 and set is empty, then answer is false
        for (int i = 1; i <= sum; i++)
          subset[i][0] = false;
      
         // Fill the subset table in botton up manner
         for (int i = 1; i <= sum; i++)
         {
           for (int j = 1; j <= n; j++)
           {
             subset[i][j] = subset[i][j-1];
             if (i >= set[j-1])
               subset[i][j] = subset[i][j] || 
                                          subset[i - set[j-1]][j-1];
           }
         }
      
         // uncomment this code to print table
         for (int i = 0; i <= sum; i++)
         {
           for (int j = 0; j <= n; j++)
              System.out.println (subset[i][j]);
           	  System.out.printf("\n");
         } 
      
         return subset[sum][n];
    }
    
    public static Map<List<Integer>, Boolean> cache = new HashMap<List<Integer>, Boolean>();

    public static boolean subSetSum(List<Integer> S, int sum) {
        if (sum == 0) return true;
        if (S.size() == 0 || sum < 0) return false;

        List<Integer> key = new ArrayList<Integer>(S); // composite (set, sum) memoization key
        key.add(sum);
        // let x be the first element of S, then there is either a solution with
        // the set S - {x} without the first element considered, or there is a
        // solution where x is accounted for, ie with the set S - {x} and sum - x
        System.out.println("key:"+key);
        if (!cache.containsKey(key)) {
            List<Integer> forwardSet = S.subList(1, S.size());
//            System.out.println(subSetSum(forwardSet, sum) || subSetSum(forwardSet, sum - S.get(0)));
            cache.put(key, subSetSum(forwardSet, sum) || subSetSum(forwardSet, sum - S.get(0)));
        }
        System.out.println("key:"+key+"value::"+cache.get(key)+" sum:"+sum);
        return cache.get(key);
    }
    // Example: 

    public static void main (String args[])
    {
          int set[] = {2,1};
          int sum = 9;
          int n = set.length;
          if (isSubsetSumDynamic(set, n, sum))
             System.out.println("Found a subset with given sum");
          else
             System.out.println("No subset with given sum");
         System.out.println(subSetSum(Arrays.asList(new Integer[] { -7, -3, -2, 5, 8 }), 13));
    }
}
