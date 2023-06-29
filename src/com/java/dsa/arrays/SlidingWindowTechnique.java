package com.java.dsa.arrays;

public class SlidingWindowTechnique {
    public static void main(String[] args) {
        int arr[] = {5 , 2 , -1 , 0 , 3};
        int n = arr.length;
        int k = 3;
        int res = maxSum2(arr,n,k);
        System.out.println(res);
    }

    private static int maxSum(int[] arr, int n, int k) {
        int sum=0,maxSum=0;
        for (int i=0;i<k;i++) {
            sum += arr[i];
        }
        maxSum = sum;
        for (int i=k;i<n;i++){
            int nextSum = sum-arr[i-k]+arr[i];
            sum=nextSum;
            maxSum=Math.max(sum,maxSum);
        }
        return maxSum;
    }

    // Returns maximum sum in a subarray of size k.
    private static int maxSum2(int arr[], int n, int k) {
        // n must be greater
        if (n < k) {
            System.out.println( "Invalid");
            return -1;
        }

        //sum of first window of size k
        int window_sum = 0;
        for (int i = 0; i < k; i++)
            window_sum += arr[i];

        // Compute sums of remaining windows by
        // removing first element of previous
        // window and adding last element of
        // current window.
        int max_sum = window_sum;
        for (int i = k; i < n; i++) {
            window_sum += (arr[i] - arr[i - k]);
            max_sum = Math.max(max_sum, window_sum);
        }
        return max_sum;
    }
}
