package com.java.multithreading.streams.parallelization;

import java.util.stream.LongStream;

public class App {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        System.out.println("Sum using sequential method "+sum(80000000));
        System.out.println("Time taken by sequential method "+(System.currentTimeMillis()-start));

        long start1 = System.currentTimeMillis();
        System.out.println("Sum using parallel method "+parallelSum(80000000));
        System.out.println("Time taken by parallel method "+(System.currentTimeMillis()-start1));

    }

    public static Long sum(int n){
        return LongStream.rangeClosed(0,n).sum();
    }

    public static Long parallelSum(int n){
        return LongStream.rangeClosed(0,n).parallel().sum();
    }

}
