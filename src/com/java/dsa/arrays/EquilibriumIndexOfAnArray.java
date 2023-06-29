package com.java.dsa.arrays;

/**
 *
 Description - Equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes. We are given an Array of integers, We have to find out the first index i from left such that -
 A[0] + A[1] + ... A[i-1] = A[i+1] + A[i+2] ... A[n-1]
 *
 */


public class EquilibriumIndexOfAnArray {
    private static int findEquilibrium(int arr[]){
        int sum=0;
        int leftSum=0;

        for(int i=0;i<arr.length;i++)
            sum+=arr[i];

        for (int i=0;i<arr.length;i++){
            sum-=arr[i];
            if(sum == leftSum) return i;
            leftSum+=arr[i];
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {-7, 1, 5, 2, -4, 3, 0};
        int res = findEquilibrium(arr);
        System.out.println(res);
    }
}
