package com.java.dsa.dp.knapsack01;

public class EqualSumPartition {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        if (total % 2 == 1)
            return false;
        int sum = total / 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int s = sum; s >= num; s--) {
                dp[s] = dp[s] || dp[s - num];
            }
        }

        return dp[sum];
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        System.out.println(new EqualSumPartition().canPartition(nums));
    }

}
