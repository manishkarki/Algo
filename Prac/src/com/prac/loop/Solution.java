package com.prac.loop;

import java.util.*;

class Solution{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            getResults(a,b,n);
        }
        in.close();
    }
    public static void getResults(int a, int b, int n){


            int result=0;
            result += a;
            for (int i = 0 ;i<n;i++){
                result += (int)Math.pow(2, i)*b;
                System.out.print(result + " "); 
            }
            System.out.println();
        }
}

