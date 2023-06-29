package com.java.dsa.stacks.problems;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class PreviousGreaterElement {
    public static void main(String[] args) {
        int arr[] = {4,2,3,1};
        int n = arr.length;
        int res[] = findPreviousGreaterElement(arr,n);
        Arrays.stream(res).forEach(i-> System.out.print(i+" "));
    }

    private static int[] findPreviousGreaterElement(int[] arr, int n) {
        int res[] = new int[n];
        Deque<Integer> stack=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            if(stack.isEmpty()){
                res[i]=-1;
                stack.add(arr[i]);
            }
            else {
                if(stack.peek()>arr[i]){
                    res[i]=stack.peek();
                }else{
                    while (!stack.isEmpty() && stack.peek()<=arr[i]){
                        stack.pop();
                    }
                    res[i]= stack.isEmpty() ? -1 : stack.peek();
                }
                stack.push(arr[i]);
            }
        }
        return res;
    }

}
