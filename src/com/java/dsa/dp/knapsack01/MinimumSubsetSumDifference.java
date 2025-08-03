package com.java.dsa.dp.knapsack01;

public class MinimumSubsetSumDifference {

    public static int minimumDifferenceOptimized(int[] nums) {

        int n = nums.length;
        int sum = 0;
        for(int s: nums){
            sum +=s;
        }
        if(sum%2 == 1) return -1;
        int target = sum/2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for(int num: nums){
            for(int s=target; s>=num; s--){
                dp[s] = dp[s] || dp[s - num];
            }
        }
        int sum1 = 0;
        for(int s=target; s>=0; s--){
            if(dp[s]){
                sum1 = s;
                break;
            }
        }
        int sum2 = sum - sum1;
        return Math.abs(sum1 - sum2);
    }
    public static int minimumDifference(int[] nums) {

        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        boolean[][] dp = new boolean[n][sum/2 + 1];

        for (int i=0; i<n; i++){
            dp[i][0] = true;
        }

        for(int s=1; s<=sum/2; s++){
            dp[0][s] = nums[0] == sum;
        }

        for(int i=1; i<n; i++){
            for (int s=1; s<=sum/2; s++){
                if(dp[i-1][s]){
                    dp[i][s] = true;
                }else if(s>=nums[i]){
                    dp[i][s] = dp[i-1][s-nums[i]];
                }
            }
        }

        int sum1 = 0;
        for (int s=sum/2; s>=0; s--){
            if(dp[n-1][s]){
                sum1 = s;
                break;
            }
        }

        int sum2 = sum - sum1;
        return Math.abs(sum1 - sum2);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,6,8,6};
        System.out.println(minimumDifferenceOptimized(nums));
    }
}
