package com.java.dsa.algo;

import java.util.Arrays;

public class SelectionSort {

    public static void selectionSort(int arr[]) {
        int n = arr.length;
        for(int i = 0;i<n-1;i++){
            int temp = arr[i];
            int pos = i;
            for (int j = i+1;j<n;j++){
                if(arr[j]<temp){
                    temp = arr[j];
                    pos = j;
                }
            }
            int t1 = arr[i];
            arr[i] = temp;
            arr[pos] = t1;
        }
    }

    public static void main(String[] args) {
        int arr[] = {4, 6, 2, 3, 7, 8, 9};
        System.out.println("Array before sorting");
        Arrays.stream(arr).forEach((ele) -> System.out.print(ele + " "));
        selectionSort(arr);
        System.out.println("\nArray after sorting");
        Arrays.stream(arr).forEach((ele) -> System.out.print(ele + " "));
    }
}
