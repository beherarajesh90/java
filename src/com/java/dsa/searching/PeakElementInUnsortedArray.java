package com.java.dsa.searching;

public class PeakElementInUnsortedArray {
    public static void main(String[] args) {
        int arr[] = {10, 20, 15, 2, 23, 90, 67};
        int res = findPeakElement(arr);
        System.out.println("One of the peak element in the array is "+res);
    }

    private static int findPeakElement(int[] arr) {
        int start = 0, end = arr.length-1;
        while (start<=end){
            int mid = start + (end-start)/2;
            if((mid == 0 || arr[mid]>arr[mid-1]) && (mid == arr.length-1 || arr[mid]>arr[mid+1])){
                return mid;
            }
            if(arr[mid-1]>arr[mid]){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return -1;
    }
}
