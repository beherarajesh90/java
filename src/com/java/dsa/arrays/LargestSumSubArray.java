package com.java.dsa.arrays;

public class LargestSumSubArray {
    public static void main(String[] args) {
        int arr[] ={-3, 4, -1, -2, 1, 5};
        int res = largestSumSubArray(arr);
        System.out.println(res);
    }

    private static int largestSumSubArray(int[] arr) {
        int maxSum=Integer.MIN_VALUE;
        int tempSum=0;
        for(int i=0;i<arr.length;i++){
            tempSum+=arr[i];
            if(maxSum < tempSum){
                maxSum=tempSum;
            }
            if(tempSum < 0){
                tempSum=0;
            }
        }
        return maxSum;
    }
}
