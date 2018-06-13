package com.prac.interview;


/**
 * @author Manish Karki
 * 
 */

public class Java8PracImpl {
	 public static int count(final String string, final String substring)
	  {
	     int count = 0;
	     int idx = 0;

	     while ((idx = string.indexOf(substring, idx)) != -1)
	     {
	        idx++;
	        count++;
	     }

	     return count;
	  }
	public static void main(String[] args) {
		String [] genes = {"a","b", "c", "aa", "d", "b"};
		int [] health = {1,2,3,4,5,6};
		String d = "caaab";
		int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int count = 0;
        
        for(int i = 1; i <= 5; i++){
        	int no = count(d, genes[i]);
            count += no*health[i];
                
        }
        System.out.println(count);
        if(min > count)
            min = count;
        if( max < count)
            max = count;
		
        int [][] arr = new int[4][0];
		System.out.println(arr[0].length);

	}
}
