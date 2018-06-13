package com.prac.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Manish Karki
 * 
 */

public class CoinChange {
	public static int change(int amount, int[] coins) {
		int[] dp = new int[amount + 1];
		dp[0] = 1;
		for (int coin : coins) {
			System.out.println("coin:"+coin);
			for (int i = coin; i <= amount; i++) {
				System.out.println("\t"+"i::->"+i+" i-coin::"+ (i-coin) +" dp[i-coin]::"+dp[i-coin]);
				dp[i] += dp[i - coin];
			}
		}
		return dp[amount];
	}
	
	public int minimumCoinBottomUp(int total, int coins[]){
        int T[] = new int[total + 1];
        int R[] = new int[total + 1];
        
        for(int i = 1; i <= total; i++){
        	T[i] = Integer.MAX_VALUE;
        	R[i] = -1;
        }
        T[0] = 0;
        for(int j = 0; j < coins.length; j++){
        	for( int i = 1; i<= total ; i++){
        		if(coins[j] <= i){
        			T[i] = Math.min(T[i], 1+T[i - coins[j]]);
        			R[i] = j;
        		}
        	}
        }
        
        printCoinCombination(R, coins);
        return T[total];
    }

    private void printCoinCombination(int R[], int coins[]) {
       //if solution is not found, the final value in R should be -1
    	if(R[R.length-1] == -1)
    		return;
    	
    	int temp = R.length -1;
    	
    	while(temp != 0){
    		System.out.println(coins[R[temp]]+" ");
    		temp -= coins[R[temp]];
    	}
    }
    
    public int numberOfSolutionsOnSpace(int total, int arr[]){

        int temp[] = new int[total+1];

        temp[0] = 1;
        for(int i=0; i < arr.length; i++){
            for(int j=1; j <= total ; j++){
                if(j >= arr[i]){
                    temp[j] += temp[j-arr[i]];
                }
            }
        }
        return temp[total];
    }

    public void printCoinChangingSolution(int total,int coins[]){
        List<Integer> result = new ArrayList<>();
        printActualSolution(result, total, coins, 0);
    }

    private void printActualSolution(List<Integer> result,int total,int coins[],int pos){
        if(total == 0){
            for(int r : result){
                System.out.print(r + " ");
            }
            System.out.print("\n");
        }
//        System.out.println("total is:"+total);
        for(int i=pos; i < coins.length; i++){
            if(total >= coins[i]){
                result.add(coins[i]);
//                System.out.println(total+" is total and result:"+result+" pos is:"+pos);
                
                printActualSolution(result,total-coins[i],coins,i);
//                System.out.println("result with result.size()-1:"+ result.get(result.size()-1));
                result.remove(result.size()-1);
            }
        }
    }


	
	public static void main(String[] args) {
		CoinChange cc = new CoinChange();
		System.out.println("combinations required:"+cc.minimumCoinBottomUp(5, new int[]{1,2,3}));
//		cc.printCoinChangingSolution(5, new int[]{1,2,5});
//		System.out.println(change(5, new int[]{1,2,5}));
	}

}
