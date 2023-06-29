package com.java.multithreading;

public class IntrinsicLockingExample {

    //here there are two independent resources still thread 2 waits for intrinsic lock acquired by thread 1
    //due to synchronized block

    public static int count1 = 0;
    public static int count2 = 0;

    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void increment1(){
        synchronized(IntrinsicLockingExample.class){
//            synchronized(lock1){ //fix for the problem
            for (int i=0;i<10;i++){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count1++;
                System.out.println("Thread 1 "+count1);
            }
        }

    }

    public static void increment2(){
        synchronized(IntrinsicLockingExample.class){
//            synchronized(lock2){ //fix for the problem
            for (int i=0;i<10;i++){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count2++;
                System.out.println("Thread 2 "+count2);
            }
        }
    }

    public static void process(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                increment1();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                increment2();
            }
        });
        t1.start();
        t2.start();

    }

    public static void main(String[] args) {
        process();
    }
}
