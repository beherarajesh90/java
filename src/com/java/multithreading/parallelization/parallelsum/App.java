package com.java.multithreading.parallelization.parallelsum;

import java.util.Random;

public class App {
    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[100000000];
        for(int i=0;i<arr.length;i++){
            arr[i]=random.nextInt(100);
        }

        //Sequential sum
        long start1 = System.currentTimeMillis();
        SequentialSum sequentialSum = new SequentialSum();
        System.out.println("Sequential sum "+sequentialSum.sum(arr));
        System.out.println(System.currentTimeMillis()-start1);

        //Parallel sum
        long start2 = System.currentTimeMillis();
        int noOfProcessors = Runtime.getRuntime().availableProcessors();
        ParallelSum parallelSum = new ParallelSum(noOfProcessors);
        System.out.println("Parallel sum "+parallelSum.sum(arr));
        System.out.println(System.currentTimeMillis()-start2);
    }
}
