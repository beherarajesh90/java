package com.java.dsa.searching;

public class TernarySearch {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
        int searchNumber = 9;
        int res = ternarySearch(arr,searchNumber);
        System.out.println(searchNumber+" is at index "+res);
    }

    private static int ternarySearch(int[] arr, int searchNumber) {

        int start=0,end=arr.length-1;

        while (start<=end){
            int mid1 = start + (end-start)/3;
            int mid2 = end - (end-start)/3;

            if(searchNumber == arr[mid1]){
                return mid1;
            }
            if(searchNumber == arr[mid2]){
                return mid2;
            }

            if(searchNumber < arr[mid1]){
                end = mid1-1;
            }
            else if(searchNumber > arr[mid2]){
                start = mid2+1;
            }
            else{
                start=mid1+1;
                end=mid2-1;
            }

        }

        return -1;
    }
}
