package com.java.dsa.arrays;

public class LeftRotateOnArrayOnDPlaces {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        int n = arr.length;
        int d = 2;
        System.out.println("Before");
        RemoveDuplicatesFromSortedArray.printArr(arr,n);
        leftRotate(arr,d,n);
        System.out.println("\nAfter");
        RemoveDuplicatesFromSortedArray.printArr(arr,n);
    }

    private static void leftRotate(int[] arr, int d, int n) {
        int temp[] = new int[d];

        for (int i=0;i<d;i++)
            temp[i]=arr[i];

        for (int i=d;i<n;i++)
            arr[i-d]=arr[i];

        for (int i=0;i<d;i++)
            arr[n-d+i]=temp[i];
    }
}
