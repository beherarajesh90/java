package com.java.dsa.arrays;

/*
* Input: arr = [-2, -5, 6, -2, -3, 1, 5, -6]
* Output: [6, -2, -3, 1, 5]
* Explanation:
* In the above input the maximum contiguous subarray sum is 7 and the elements
* of the subarray are [6, -2, -3, 1, 5]
* */
public class MaximumSubArraySum {
    public static void main(String[] args) {
        int arr[]={-2, -5, 6, -2, -3, 1, 5, -6};
        int n = arr.length;
        maxSubarraySum(arr,n);
    }

    private static void maxSubarraySum(int[] arr, int n) {
        int cur_max = arr[0];
        int global_max = arr[0];
        int endIndex=0;

        for(int i=1;i<n;i++){
            cur_max = Math.max(cur_max+arr[i],arr[i]);
            if(global_max<cur_max){
                global_max=cur_max;
                endIndex=i;
            }
        }
        int startIndex=endIndex;
        while (startIndex>=0){
            global_max-=arr[startIndex];
            if(global_max == 0) break;
            startIndex--;
        }
        for (int i=startIndex;i<=endIndex;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
