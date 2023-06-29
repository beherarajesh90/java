package com.java.multithreading.forkjoinFramework.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class App {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        PrintingArrayRecursiveAction action = new PrintingArrayRecursiveAction(list);
        pool.invoke(action);
    }
}
