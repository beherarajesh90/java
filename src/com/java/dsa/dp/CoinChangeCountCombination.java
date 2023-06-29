package com.java.dsa.dp;

import java.util.Arrays;

public class CoinChangeCountCombination {
    static int getCount(int[] coins,int sum,int n){

//        if sum 0 one selection is possible selecting nothing
        if(sum==0) return 1;
//        if no coins we cannot select so 0
        if(n==0) return 0;
//        not considering the last item
        int res=getCount(coins,sum,n-1);
        if(coins[n-1]<=sum){
//           consider the item
            res+=getCount(coins,sum-coins[n-1],n);
        }
        return res;
    }

    static int getCountUsingDPTabulation(int[] coins,int sum,int n){
        int dp[][]=new int[sum+1][n+1];
        for(int i=0;i<=sum;i++){
            dp[i][0]=0;
        }
        for(int i=0;i<=n;i++){
            dp[0][i]=1;
        }

        for(int i=1;i<=sum;i++){
            for(int j=1;j<=n;j++){
                dp[i][j]=dp[i][j-1];
                if(coins[j-1]<=i){
                    dp[i][j]+=dp[i-coins[j-1]][j];
                }
            }
        }
        return dp[sum][n];
    }

    public static void main(String[] args) {
        int res=getCountUsingDPTabulation(new int[]{1,2,3},4,3);
        System.out.println(res);
    }
}
