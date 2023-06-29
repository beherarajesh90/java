package com.java.multithreading.streams.parallelization;

import java.util.stream.IntStream;

public class App2 {
    public static void main(String[] args) {

        //sequential
        long start1 = System.currentTimeMillis();
        long res1 = IntStream.rangeClosed(2,Integer.MAX_VALUE/100).filter(App2::isPrime).count();
        System.out.println("sequential "+res1+" "+(System.currentTimeMillis()-start1));


        //parallel
        long start2 = System.currentTimeMillis();
        long res2 = IntStream.rangeClosed(2,Integer.MAX_VALUE/100).parallel().filter(App2::isPrime).count();
        System.out.println("parallel "+res2+" "+(System.currentTimeMillis()-start2));

    }
    public static boolean isPrime(long n){
        if(n<=1) return false;
        if(n==2) return true;
        if(n%2==0) return false;

        long maxDivisor = (long) Math.sqrt(n);

        for(int i=3;i<maxDivisor;i++){
            if(n%i==0) return false;
        }
        return true;
    }
}
