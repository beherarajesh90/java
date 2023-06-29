package com.java.dsa.arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int arr[] = {1,1,2,2,3,3,3};
        int n=arr.length;
        System.out.println("Before removing");
        printArr(arr,n);
        n=removeDups(arr,n);
        System.out.println("\nAfter removing dups");
        printArr(arr,n);
    }

    private static int removeDups(int[] arr, int n) {
        int tempIndex = 1;
        for (int i=0;i<n;i++){
            if(arr[tempIndex-1]!=arr[i]){
                arr[tempIndex]=arr[i];
                tempIndex++;
            }
        }
        return tempIndex;
    }

    public static void printArr(int[] arr,int n) {
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
