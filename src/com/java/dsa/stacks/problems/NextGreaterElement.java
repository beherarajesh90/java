package com.java.dsa.stacks.problems;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextGreaterElement {
    public static void main(String[] args) {
        long arr[] = {1,3,2,4};
        int n =arr.length;
        long res[] = nextLargerElement(arr,n);
        Arrays.stream(res).forEach(i-> System.out.print(i+" "));
    }
    public static long[] nextLargerElement(long[] arr, int n)
    {
        // Your code here
        Deque<Long> stack = new ArrayDeque<>();
        long res[] = new long[n];
        for(int i=n-1;i>=0;i--){
            if(stack.isEmpty()){
                stack.push(arr[i]);
                res[i]=-1;
            }else{
                if(stack.peek() > arr[i]){
                    res[i]=stack.peek();
                }
                else{
                    while(!stack.isEmpty() &&  arr[i]>=stack.peek()){
                        stack.pop();
                    }
                    res[i]=stack.isEmpty() ? -1 : stack.peek() ;
                }
                stack.push(arr[i]);
            }
        }
        return res;
    }
}
