package com.java.multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Worker{

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public void produce() throws InterruptedException {
            lock.lock();
            System.out.println("Inside produce method");
            condition.await();
            System.out.println("Again in produce method");
            lock.unlock();
    }
    public void consume(){

            lock.lock();
            System.out.println("Inside consume method");
            condition.signal();
            System.out.println("Still Inside consume method");
            lock.unlock();
    }
}

public class ProducerConsumerUsingReentrantLockExample {
    public static void main(String[] args) {
        Worker p = new Worker();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    p.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
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
