package com.java.multithreading.practice.locks;

public class InterruptibleThread implements Runnable {
    @Override
    public void run() {
        while (true) {
            // Perform some work here
            System.out.println("Thread is running");

            // Check if the thread is interrupted
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Thread was interrupted");
                break; // Exit the loop
            }

            try {
                // Simulate some work with sleep
                System.out.println("sleeping");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // Handle the interruption during sleep
                System.out.println("Thread was interrupted during sleep");
                Thread.currentThread().interrupt(); // Preserve the interrupt status
                break; // Exit the loop
            }
        }

        System.out.println("Thread has stopped");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new InterruptibleThread());
        thread.start();

        // Allow the thread to run for a few seconds
        Thread.sleep(3000);

        // Interrupt the thread
        System.out.println("Interrupting the thread");
        thread.interrupt();
    }
}
