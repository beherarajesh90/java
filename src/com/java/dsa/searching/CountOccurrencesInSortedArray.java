package com.java.dsa.searching;

public class CountOccurrencesInSortedArray {
    public static void main(String[] args) {
        int arr[] = {1, 2, 2, 2, 2, 3, 4, 7, 8, 8};
        int n = arr.length;
        int x = 1;
        int firstOccurrenceIndex = firstOccurrence(arr,x,n);
        int lastOccurrenceIndex = lastOccurrence(arr,x,n);
        int c = lastOccurrenceIndex-firstOccurrenceIndex+1;
        System.out.println("No of occurrences of "+x+" is "+c);
    }

    private static int firstOccurrence(int[] arr, int x, int n) {
        int start=0,end=n-1;
        while (start<=end){
            int mid = start + (end - start)/2;
            if(arr[mid]<x){
                start = mid+1;
            }
            else if(arr[mid]>x){
                end = mid-1;
            }
            else{
                if(mid==0 || arr[mid]!=arr[mid-1]){
                    return mid;
                }
                else{
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    private static int lastOccurrence(int[] arr, int x, int n) {
        int start=0,end=n-1;
        while (start<=end){
            int mid = start + (end - start)/2;
            if(arr[mid]<x){
                start = mid+1;
            }
            else if(arr[mid]>x){
                end = mid-1;
            }
            else{
                if(mid==n-1 || arr[mid]!=arr[mid+1]){
                    return mid;
                }
                else{
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
