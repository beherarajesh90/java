package com.java.multithreading;

public class ThreadLocalExample {
    // Creating a ThreadLocal variable
    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 1);

    public static void main(String[] args) {
        Runnable task = () -> {
            // Get the initial value of the ThreadLocal variable
            int value = threadLocal.get();
            System.out.println(Thread.currentThread().getName() + " initial value: " + value);

            // Set a new value for the ThreadLocal variable
            threadLocal.set(value * 2);
            System.out.println(Thread.currentThread().getName() + " modified value: " + threadLocal.get());

            // Remove the value of the ThreadLocal variable
            threadLocal.remove();
            System.out.println(Thread.currentThread().getName() + " removed value: " + threadLocal.get());
        };

        Thread thread1 = new Thread(task, "Thread-1");
        Thread thread2 = new Thread(task, "Thread-2");

        thread1.start();
        thread2.start();
    }
}

