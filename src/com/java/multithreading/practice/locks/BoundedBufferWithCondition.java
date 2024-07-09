package com.java.multithreading.practice.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class BoundedBufferWithCondition {
    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    private final Object[] items = new Object[10];
    private int putIndex, takeIndex, count;

    public void put(Object item) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length) {
                notFull.await(); // Wait until not full
            }
            items[putIndex] = item;
            if (++putIndex == items.length) putIndex = 0;
            count++;
            notEmpty.signal(); // Signal that the buffer is not empty
        } finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                notEmpty.await(); // Wait until not empty
            }
            Object item = items[takeIndex];
            if (++takeIndex == items.length) takeIndex = 0;
            count--;
            notFull.signal(); // Signal that the buffer is not full
            return item;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BoundedBufferWithCondition buffer = new BoundedBufferWithCondition();
        
        // Producer
        Thread producer = new Thread(() -> {
            try {
                for (int i = 0; i < 20; i++) {
                    buffer.put(i);
                    System.out.println("Produced " + i);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Consumer
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 0; i < 20; i++) {
                    Object item = buffer.take();
                    System.out.println("Consumed " + item);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();
    }
}

//Comparison
//        Using Condition:
//        Flexibility: Separate conditions for notFull and notEmpty.
//        Efficiency: Only signals the necessary condition, reducing unnecessary context switches and notifications.
//        Readability: Clear separation of different wait conditions.
//
//        Using wait() and notifyAll():
//        Simplicity: Uses intrinsic locks without requiring additional classes.
//        Broadcasting: Always notifies all waiting threads, which can lead to inefficiencies (e.g., waking up a producer when a consumer is what’s needed).