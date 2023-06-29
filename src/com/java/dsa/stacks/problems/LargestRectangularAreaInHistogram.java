package com.java.dsa.stacks.problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangularAreaInHistogram {
    public static void main(String[] args) {
        int arr[] = {60,20,50,40,10,50,60};
        int n = arr.length;
        int res = getMaxArea(arr,n);
        System.out.println(res);
    }

    private static int getMaxArea(int[] arr, int n) {
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        for (int i=0;i<n;i++){
            while (!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                int tp = stack.pop();
                int curr = arr[tp]*( stack.isEmpty() ? i : (i-stack.peek()-1) );
                res = Math.max(res,curr);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            int tp = stack.pop();
            int curr = arr[tp]*( stack.isEmpty() ? n : (n-stack.peek()-1) );
            res = Math.max(res,curr);
        }
        return res;
    }
}
