package com.java.multithreading.practice.locks;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    private final Semaphore semaphore = new Semaphore(3);

    public void doWork(){
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " is working");
            Thread.sleep(2000);
        } catch (Exception e){
            Thread.currentThread().interrupt();
        } finally {
            semaphore.release();
        }
    }

    public static void main(String[] args) {
        SemaphoreExample example = new SemaphoreExample();
        for (int i = 0; i < 10; i++) {
            new Thread(example::doWork, "Thread-" + i).start();
        }
    }
}
