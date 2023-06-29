package com.java.dsa.arrays;

public class MoveZeroesToEnd {
    public static void main(String[] args) {
        int arr[] = {0, 1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
        int n = arr.length;
        System.out.println("Before");
        RemoveDuplicatesFromSortedArray.printArr(arr,n);
        moveZeroesToEnd(arr,n);
        System.out.println("\nAfter");
        RemoveDuplicatesFromSortedArray.printArr(arr,n);
    }

    private static void moveZeroesToEnd(int[] arr, int n) {
        int count=0;

        for(int i=0;i<n;i++){
            if(arr[i]!=0){
                arr[count++]=arr[i];
            }
        }

        for (int i=count;i<n;i++){
            arr[i]=0;
        }

    }
}
