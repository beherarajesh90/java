package com.java.multithreading.forkjoinFramework.recursiveTask;

import java.util.concurrent.ForkJoinPool;

public class App {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        RecursiveTaskExample task = new RecursiveTaskExample(10000);
        System.out.println(pool.invoke(task));
    }
}
