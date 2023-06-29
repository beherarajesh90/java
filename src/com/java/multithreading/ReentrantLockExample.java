package com.java.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

    private static int counter = 0;
    private static final Lock lock = new ReentrantLock(); //by default fairness parameter is true

    private static void increment(){
        lock.lock();
        try{
            for(int i=0;i<10000;i++){
                counter++;
            }
        }
        finally {
            lock.unlock(); //if any exception occurs finally will always execute thereby releasing the lock to prevent deadlock situation
        }

    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                increment();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                increment();
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

        System.out.println("Count "+counter);
    }
}
