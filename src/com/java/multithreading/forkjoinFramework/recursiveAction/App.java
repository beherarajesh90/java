package com.java.multithreading.forkjoinFramework.recursiveAction;

import java.util.concurrent.ForkJoinPool;

public class App {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool(); // pool creates threads based on processors count
        SimpleRecursiveAction action = new SimpleRecursiveAction(1000);
        pool.invoke(action);
    }
}
