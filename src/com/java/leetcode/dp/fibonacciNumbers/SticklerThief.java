package com.java.leetcode.dp.fibonacciNumbers;

import java.util.Arrays;

public class SticklerThief {

    //recursive solution
    public static int findMaxSumRecursive(int[] arr, int n)
    {
        // Your code here
        if(n<=0) return 0;
        if(n==1) return arr[0];
        int pick = arr[n-1]+findMaxSumRecursive(arr, n-2);
        int noPick = findMaxSumRecursive(arr,n-1);
        return Math.max(pick, noPick);
    }

    //DP top-down approach
    private static int findMaxSumTopDownDPRecursive(int[] arr, int n, int[] memo)
    {
        // Your code here
        if(n<=0) return 0;
        if(n==1) return arr[0];
        if(memo[n]!=-1) return memo[n];
        int pick = arr[n-1]+findMaxSumTopDownDPRecursive(arr, n-2, memo);
        int noPick = findMaxSumTopDownDPRecursive(arr,n-1, memo);
        memo[n] = Math.max(pick, noPick);
        return memo[n];
    }

    public static int findMaxSumTopDownDP(int[] arr, int n){
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        return findMaxSumTopDownDPRecursive(arr,n,memo);
    }

    //DP bottom-up approach
    public static int findMaxSumBottomUpDP(int[] arr, int n){
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = arr[0];
        for(int i=2; i<=n; i++){
            dp[i] = Math.max(arr[i-1]+dp[i-2], dp[i-1]);
        }
        return dp[n];
    }

    //DP bottom-up approach: space optimized
    public static int findMaxSumBottomUpDPSpaceOptimized(int[] arr, int n){
        if(n<=0) return 0;
        if(n==1) return arr[0];
        int prevPrev = 0;
        int prev = arr[0];
        int res = 0;
        for(int i=1; i<n; i++){
            res = Math.max(arr[i]+prevPrev, prev);
            prevPrev = prev;
            prev = res;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {9,4,11,12,6,12};
        int res = findMaxSumBottomUpDPSpaceOptimized(arr,6);
        System.out.println(res);
    }
}
