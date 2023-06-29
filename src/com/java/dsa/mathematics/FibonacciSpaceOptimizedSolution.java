package com.java.dsa.mathematics;

public class FibonacciSpaceOptimizedSolution {

    private static int fib(int n){
        if(n==0 || n==1){
            return n;
        }
        int a=0,b=1,c=0;
        for(int i=2;i<=n;i++){
            c=a+b;
            a=b;
            b=c;
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(fib(6));
    }
}
