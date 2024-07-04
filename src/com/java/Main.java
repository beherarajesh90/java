package com.java;

public class Main{

    public static void main(String[] args) throws InterruptedException {

        System.out.println("main thread started");
        SharedResource sr = new SharedResource();

        Thread producerThread = new Thread(()->{
            System.out.println("producer thread:"+Thread.currentThread().getName());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            sr.addItem();
        });

        Thread consumerThread = new Thread(()->{
            System.out.println("consumer thread: "+Thread.currentThread().getName());
            sr.consumeItem();
        });

        producerThread.start();
        consumerThread.start();

        producerThread.join();
        consumerThread.join();

        System.out.println("main thread ended");

    }
}

class SharedResource{
    private boolean resourceAvailable;

    public SharedResource(){
        this.resourceAvailable = false;
    }

    public synchronized void addItem(){
        resourceAvailable = true;
        System.out.printf("resource made available by thread %s. Notifying all waiting threads\n", Thread.currentThread().getName());
        notifyAll();
    }

    public synchronized void consumeItem(){
        System.out.printf("consume thread invoked by thread %s\n", Thread.currentThread().getName());
        while (!resourceAvailable){
            System.out.printf("Thread %s is waiting..\n", Thread.currentThread().getName());
            try {
                wait(); // release monitor lock
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("consumed by thread "+Thread.currentThread().getName());
        }
    }

}















