package com.java.dsa.dp.knapsack01;

public class CountOfSubsetSum {

    public static int count(int[] nums, int sum) {
        int n = nums.length;
        int[] dp = new int[sum + 1];
        dp[0] = 1;

        for(int i=0; i<n; i++) {
            for(int s=sum; s>=nums[i]; s--) {
                dp[s] += dp[s- nums[i]];
            }
        }

        return dp[sum];
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,3};
        System.out.println(count(nums, 4));
    }
}
