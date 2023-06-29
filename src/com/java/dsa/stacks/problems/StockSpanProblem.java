package com.java.dsa.stacks.problems;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class StockSpanProblem {
    public static void main(String[] args) {
        int price[]={100, 80, 60, 70, 60, 75, 85};
        int n = price.length;
        int arr[] = calculateSpan(price,n);
        Arrays.stream(arr).forEach(i-> System.out.print(i+" "));
    }

        //Function to calculate the span of stockâ€™s price for all n days.
        public static int[] calculateSpan(int price[], int n)
        {

            Deque<Integer> stack = new ArrayDeque<>();
            int arr[] = new int[n];
            for(int i=0;i<n;i++){
                while(!stack.isEmpty() && price[stack.peek()]<=price[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    arr[i]=i+1;
                }
                else{
                    int top = stack.peek();
                    arr[i]=(i-top);
                }
                stack.push(i);
            }
            return arr;

            // // Your code here (not so efficient approach)
            // Deque<Integer> stack = new ArrayDeque<>();
            // Deque<Integer> temp = new ArrayDeque<>();
            // int span[]=new int[n];
            // int si=0;
            // for(int i=0;i<n;i++){
            //     stack.push(price[i]);
            //     while (!stack.isEmpty() && stack.peek()<=price[i]){
            //         temp.push(stack.pop());
            //     }
            //     span[si++]=temp.size();
            //     while (!temp.isEmpty()){
            //         stack.push(temp.pop());
            //     }
            // }
            // return span;


        }
}
