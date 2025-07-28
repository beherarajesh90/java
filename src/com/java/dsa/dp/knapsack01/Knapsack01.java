package com.java.dsa.dp.knapsack01;

class Knapsack01 {
    static int knapsack(int W, int val[], int wt[]) {
        // code here
        if(W <=0 || val.length==0 || val.length!=wt.length)
            return 0;

        int n = val.length;
        int[] dp = new int[W+1];

        for(int c=0; c<=W; c++){
            if(wt[0]<=c){
                dp[c]=val[0];
            }
        }

        for(int i=1;i<n;i++){
            for(int c=W; c>=0; c--){
                int included=0,excluded=0;
                if(wt[i]<=c){
                    included = val[i]+dp[c-wt[i]];
                }
                excluded = dp[c];
                dp[c] = Math.max(included, excluded);
            }
        }
        return dp[W];
    }

    public static void main(String[] args) {
        int val[] = {1,2,3};
        int wt[] = {4, 5, 1};
        int W = 4;
        System.out.println(knapsack(W, val, wt));
    }
}

