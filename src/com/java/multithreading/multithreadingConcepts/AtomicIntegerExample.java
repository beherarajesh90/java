package com.java.multithreading.multithreadingConcepts;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {

    private AtomicInteger count = new AtomicInteger(0);

    private void increment(){
        for(int i=0;i<10000;i++){
            count.getAndIncrement();
        }
    }

    public static void main(String[] args) {
        AtomicIntegerExample a = new AtomicIntegerExample();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                a.increment();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                a.increment();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Count is "+a.count);
    }
}
