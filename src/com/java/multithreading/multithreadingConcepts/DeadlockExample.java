package com.java.multithreading.multithreadingConcepts;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
//prevent cyclic dependency
//acquiring the lock in same order will prevent the deadlock
public class DeadlockExample {

    public static void main(String[] args) {

        DeadlockExample deadlock = new DeadlockExample();
        new Thread(deadlock::worker1,"worker1").start();
        new Thread(deadlock::worker2,"worker1").start();
    }

    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    public void worker1(){
        lock1.lock();
        System.out.println("worker 1 acquiring lock 1");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock2.lock();
        System.out.println("worker 1 acquiring lock 2 ");
        lock1.unlock();
        lock2.unlock();
    }

    public void worker2(){
        lock2.lock();
//        comment above line and uncomment below line to prevent deadlock
//        lock1.lock();
        System.out.println("worker 2 acquiring lock 2");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock1.lock();
//        comment above line and uncomment below line to prevent deadlock
//        lock2.lock();
        System.out.println("worker 2 acquiring lock 1 ");
        lock2.unlock();
        lock1.unlock();
    }
}
