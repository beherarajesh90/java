package com.java.multithreading.forkjoinFramework.task2;

import java.util.concurrent.ForkJoinPool;

public class App {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        FibonacciRecursiveTask task = new FibonacciRecursiveTask(100);
        System.out.println(pool.invoke(task));
    }
}
