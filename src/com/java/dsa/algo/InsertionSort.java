package com.java.dsa.algo;

import java.util.Arrays;

public class InsertionSort {
    //my implementation
//    public static void insertionSort(int arr[]){
//        int n = arr.length;
//        int ind = -1;
//        for(int i=0;i<n-1;i++){
//            ind = i+1;
//            while( ind>0 && arr[ind] < arr[ind-1]){
//                swap(arr,ind,ind-1);
//                ind--;
//            }
//        }
//    }
//    public static void swap(int arr[],int ind1,int ind2){
//        int temp = arr[ind1];
//        arr[ind1] = arr[ind2];
//        arr[ind2] = temp;
//    }

    //GFG
    public static void insertionSort(int arr[]){
        int n = arr.length;
        for(int i=1;i<n;i++){
            int temp = arr[i];
            int j = i-1;
            while(j>=0 && arr[j]>temp){
                arr[j+1]=arr[j];
                j = j - 1;
            }
            arr[j+1] = temp;
        }
    }
    public static void main(String[] args) {
        int arr[] = {4, 6, 2, 3, 7, 8, 9};
        System.out.println("Array before sorting");
        Arrays.stream(arr).forEach((ele) -> System.out.print(ele + " "));
        insertionSort(arr);
        System.out.println("\nArray after sorting");
        Arrays.stream(arr).forEach((ele) -> System.out.print(ele + " "));
    }
}
