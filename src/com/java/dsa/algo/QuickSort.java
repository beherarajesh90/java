package com.java.dsa.algo;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    public static void quickSort(int arr[]){
        quickSort(arr,0,arr.length-1);
    }

    public static void quickSort(int arr[],int start,int end){
        if(start >= end){
            return;
        }

        //choosing index randomly
        int pivotIndex = new Random().nextInt(end-start)+start;
        int pivot = arr[pivotIndex];
        swap(arr,pivotIndex,end);

        int leftPointer = partition(arr,start,end,pivot);
        quickSort(arr,start,leftPointer-1);
        quickSort(arr,leftPointer+1,end);
    }

    public static int partition(int arr[],int start,int end,int pivot){
        int leftIndex = start;
        int rightIndex = end-1;
        while (leftIndex < rightIndex){
            while(arr[leftIndex] <= pivot && leftIndex < rightIndex){
                leftIndex++;
            }
            while (arr[rightIndex] >= pivot && leftIndex < rightIndex){
                rightIndex--;
            }
            swap(arr,leftIndex,rightIndex);
        }
        if(arr[leftIndex] > pivot){
            swap(arr,leftIndex,end);
        }else{
            leftIndex = end;
        }
        return leftIndex;
    }

    public static void swap(int arr[],int num1,int num2){
        int temp = arr[num1];
        arr[num1] = arr[num2];
        arr[num2] = temp;
    }

    public static void main(String[] args) {
        int arr[] = {4,6,2,3,7,8,9};
        System.out.println("Array before sorting");
        Arrays.stream(arr).forEach((ele)-> System.out.print(ele+" "));
        quickSort(arr);
        System.out.println("\nArray after sorting");
        Arrays.stream(arr).forEach((ele)-> System.out.print(ele+" "));
    }
}
