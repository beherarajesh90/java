package com.java.multithreading.forkjoinFramework.task2;

import java.util.concurrent.RecursiveTask;

public class FibonacciRecursiveTask extends RecursiveTask<Integer> {

    private int n;

    public FibonacciRecursiveTask(int n){
        this.n = n;
    }

    @Override
    protected Integer compute() {

        // F(0) = F(1) = 0
        if(n <= 1)
            return n;

        FibonacciRecursiveTask fib1 = new FibonacciRecursiveTask(n-1);
        FibonacciRecursiveTask fib2 = new FibonacciRecursiveTask(n-2);

//        fib1.fork();
        fib2.fork();

//        return fib1.join()+ fib2.join();
          return fib1.compute()+ fib2.join(); //optimized approach

    }
}