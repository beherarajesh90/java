package com.java.multithreading.practice.locks;

public class BoundedBufferWithObject {
    private final Object lock = new Object();

    private final Object[] items = new Object[10];
    private int putIndex, takeIndex, count;

    public void put(Object item) throws InterruptedException {
        synchronized (lock) {
            while (count == items.length) {
                lock.wait(); // Wait until not full
            }
            items[putIndex] = item;
            if (++putIndex == items.length) putIndex = 0;
            count++;
            lock.notifyAll(); // Notify all waiting threads
        }
    }

    public Object take() throws InterruptedException {
        synchronized (lock) {
            while (count == 0) {
                lock.wait(); // Wait until not empty
            }
            Object item = items[takeIndex];
            if (++takeIndex == items.length) takeIndex = 0;
            count--;
            lock.notifyAll(); // Notify all waiting threads
            return item;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BoundedBufferWithObject buffer = new BoundedBufferWithObject();
        
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
