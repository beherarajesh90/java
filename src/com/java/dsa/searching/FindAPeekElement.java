package com.java.dsa.searching;

public class FindAPeekElement {
    public static void main(String[] args) {
        int arr[] = { 10, 11, 15, 16 , 23, 90, 67 };
        int n = arr.length;
        System.out.println("Index of a peak point is "
                + findPeak(arr, n));
    }

    private static int findPeak(int[] arr, int n) {
        int start = 0, end = n-1;
        while (start <= end){
            int mid = start + (end-start)/2;
            if((mid==0 && arr[mid]>arr[mid+1])|| (mid==n-1 && arr[mid]>arr[mid-1])){
                return mid;
            }
            if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]){
                return mid;
            }
            if(mid > 0 && arr[mid-1]>arr[mid]){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return -1;
    }
}
