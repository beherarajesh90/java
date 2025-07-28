package com.java.dsa.dp.knapsack01;

public class EqualSubsetSumPartition {
    public static boolean canPartition(int[] nums, int sum) {
        int n = nums.length;
        boolean[] dp = new boolean[sum+1];
        dp[0] = true;
        for(int s=1; s<=sum; s++){
            dp[s] = nums[0] == s;
        }

        for(int i=1;i<n; i++){
            for(int s=sum; s>=0; s--){
                if(!dp[s] && s>=nums[i]) dp[s] = dp[s-nums[i]];
            }
        }

        return dp[sum];
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        System.out.println(canPartition(nums, 12));
    }
}
