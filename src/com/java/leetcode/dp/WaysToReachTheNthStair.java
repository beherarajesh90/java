package com.java.leetcode.dp;

public class WaysToReachTheNthStair {
    static int countWays(int n)
    {
        // your code here
        int mod = 1000000007;
        if(n==0) return 0;
        if(n==1) return 1;
        if(n==2) return 2;
        int prev1=2,prev2=1,res=0;

        for(int i=3; i<=n; i++){
            res = (prev1+prev2)%mod;
            prev2 = prev1;
            prev1 = res;
        }

        return res;
    }

    public static void main(String[] args) {
        int res = countWays(55);
        System.out.println(res);
    }
}
