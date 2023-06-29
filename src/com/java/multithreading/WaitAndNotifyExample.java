package com.java.multithreading;

class Process{

    public void produce(){
        synchronized (this){
            System.out.println("Inside produce method");
            try {
                wait(); //waits until the other thread calls notify
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Again in produce method");
        }
    }
    public void consume(){
        synchronized (this){
            System.out.println("Inside consume method");
            notify(); //it is not going to handle lock. we can make further operations
            System.out.println("Still Inside consume method");
        }
    }
}

public class WaitAndNotifyExample {
    public static void main(String[] args) {
        Process p = new Process();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                p.produce();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                p.consume();
            }
        });
        t1.start();
        t2.start();
    }
}
