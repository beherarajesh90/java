package com.java.dsa.deque;

import java.util.Deque;
import java.util.LinkedList;

public class MaxOfAllSubArraysOfSizeKSolution {

    public static void printMax(int arr[], int N, int K){
        Deque<Integer> dq = new LinkedList<>();
        int i;
        for(i=0; i<K; i++){
            while (!dq.isEmpty() && arr[i]>=arr[dq.peekLast()]){
                dq.pollLast();
            }
            dq.addLast(i);
        }
        for(; i<N; i++){
            System.out.print(arr[dq.peekFirst()]+" ");
            while (!dq.isEmpty() && dq.peekFirst()<=i-K){
                dq.pollFirst();
            }
            while (!dq.isEmpty() && arr[i]>=arr[dq.peekLast()]){
                dq.pollLast();
            }
            dq.addLast(i);
        }
        System.out.print(arr[dq.peekFirst()]+" ");
    }

    public static void main(String[] args) {
        int arr[] = { 12, 1, 78, 90, 57, 89, 56 };
        int K = 3;

        printMax(arr, arr.length, K);
    }
}
