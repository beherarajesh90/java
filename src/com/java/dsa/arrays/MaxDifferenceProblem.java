package com.java.dsa.arrays;

public class MaxDifferenceProblem {
    public static void main(String[] args) {
        int arr[] = {1, 2, 90, 10, 110};
        int n = arr.length;

        int res = maxDiff(arr,n);
        System.out.println(res);
    }

    private static int maxDiff(int[] arr, int n) {
        int max_diff=arr[1]-arr[0];
        int min_ele=arr[0];
        for(int i=1;i<n;i++){
            if(arr[i]-min_ele>max_diff){
                max_diff=arr[i]-min_ele;
            }
            if(arr[i]<min_ele){
                min_ele=arr[i];
            }
        }
        return max_diff;
    }
}
