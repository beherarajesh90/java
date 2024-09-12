package com.java.leetcode.dp.longestCommonSubstring;

public class LongestCommonSubstring {

    //iterative approach
    public static int lcs(String s1, String s2, int m, int n){
        int res = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int cur = 0;
                while (i+cur < m && j+cur<n && s1.charAt(i+cur) == s2.charAt(j+cur)){
                    cur++;
                }
                res = Math.max(res,cur);
            }
        }
        return res;
    }

    //recursive approach
    public static int lcsRecursive(String s1, String s2, int m, int n){
        int res = 0;
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                res = Math.max(res,lcsRecursiveHelper(s1,s2,i,j));
            }
        }
        return res;
    }

    private static int lcsRecursiveHelper(String s1, String s2, int m, int n){
        if(m==0 || n==0 || s1.charAt(m-1) != s2.charAt(n-1)) return 0;
        return 1 + lcsRecursiveHelper(s1,s2,m-1,n-1);
    }

    //DP top down approach
    public static int lcsTopDown(String s1, String s2, int m, int n){
        int[][] memo = new int[m+1][n+1];
        int res = 0;
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    memo[i][j] = memo[i-1][j-1] + 1;
                    res = Math.max(res, memo[i][j]);
                }else {
                    memo[i][j] = 0;
                }
            }
        }
        return res;
    }

    //DP top down space optimized
    public static int lcsTopDownSpaceOptimized(String s1, String s2, int m, int n){
        int[] prev = new int[n+1];
        int res = 0;
        for(int i=1; i<=m; i++){
            int[] cur = new int[n+1];
            for(int j=1; j<=n; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    cur[j] = prev[j-1] + 1;
                    res = Math.max(res, cur[j]);
                }else {
                    cur[j] = 0;
                }
            }
            prev = cur;
        }
        return res;
    }

    public static void main(String[] args) {
        String str1 = "geeks1s2z";
        String str2 = "s1s2zgeekjkl";
        int res = lcsTopDownSpaceOptimized(str1, str2, str1.length(), str2.length());
        System.out.println("Length of longest common substring is "+res);
    }
}
