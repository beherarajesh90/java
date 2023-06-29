package com.java.dsa.searching;

public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
        int searchNumber = 2;
        int res = binarySearch(arr,searchNumber);
        System.out.println(searchNumber+" is at index "+res);
    }

    private static int binarySearch(int[] arr, int searchNumber) {

        int start=0,end=arr.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(searchNumber == arr[mid]){
                return mid;
            }
            else if(searchNumber < arr[mid]){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return -1;

    }
}
