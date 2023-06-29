package com.java.dsa.dp;

import java.util.Arrays;

public class LeastCommonSubsequenceUsingDpMemoization {
    public static int[][] memo=new int[6][6];
    public static int lcsUsingDP(String s1, String s2, int m, int n){
        if(memo[m][n]!=-1){
            return memo[m][n];
        }
        if(m==0||n==0){
            memo[m][n]=0;
        }
        else{
            //last element in both string matches then search for next common element
            if(s1.charAt(m-1)==s2.charAt(n-1)){
                memo[m][n] = 1+ lcsUsingDP(s1,s2,m-1,n-1);
            }
            else {
                memo[m][n]=Math.max(lcsUsingDP(s1,s2,m-1,n), lcsUsingDP(s1,s2,m,n-1));
            }
        }
        return memo[m][n];
    }
    public static void main (String[] args)
    {
        for(int i=0;i<=5;i++){
            Arrays.fill(memo[i],-1);
        }
        lcsUsingDP("afbgc","sagbg",5,5);
        System.out.println(memo[5][5]);
    }
}
