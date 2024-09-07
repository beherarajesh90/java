package com.java.leetcode.dp;

public class FibonacciNumbersBottomUpDP {
    public static long findNthFibonacci(int number)
    {
        // Your Code Here
        if(number<=1)
            return number;
        long prev=0,prev2=1,res=0;
        for(int i=2;i<=number;i++){
            res=prev+prev2;
            prev=prev2;
            prev2=res;
        }
        return res;
    }

    public static void main(String[] args) {
        long res = findNthFibonacci(50);
        System.out.println(res);
    }
}
