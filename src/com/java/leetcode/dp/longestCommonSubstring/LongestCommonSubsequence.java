package com.java.leetcode.dp.longestCommonSubstring;

public class LongestCommonSubsequence {

    //recursive
    public static int lcs(String s1, String s2, int m, int n){
        if(m==0  || n==0) return 0;
        if(s1.charAt(m-1) == s2.charAt(n-1)){
            return 1 + lcs(s1,s2,m-1,n-1);
        }
        return Math.max(lcs(s1,s2,m,n-1),lcs(s1,s2,m-1,n));
    }

    //DP top down
    public static int lcsTopDown(String s1, String s2, int m, int n){
        int[][] memo = new int[m+1][n+1];
        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                memo[i][j]=-1;
            }
        }
        return lcsTopDownRecursive(s1,s2,m,n,memo);
    }

    public static int lcsTopDownRecursive(String s1, String s2, int m, int n, int[][] memo){
        if(m==0 || n==0) return 0;
        if(memo[m][n]!=-1) return memo[m][n];
        if(s1.charAt(m-1)==s2.charAt(n-1)){
            memo[m][n] = 1 + lcsTopDownRecursive(s1,s2,m-1,n-1,memo);
            return memo[m][n];
        }
        memo[m][n] = Math.max(lcsTopDownRecursive(s1,s2,m-1,n,memo), lcsTopDownRecursive(s1,s2,m,n-1,memo));
        return memo[m][n];
    }

    //DP bottom up
    public static int lccBottomUp(String s1, String s2, int m, int n){

        int[][] dp = new int[m+1][n+1];

        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(i==0||j==0) dp[i][j]=0;
                else if(s1.charAt(i-1)==s2.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args)
    {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        System.out.println("Length of LCS is" + " " +
                lccBottomUp( s1,s2,s1.length(), s2.length() ) );
    }
}
