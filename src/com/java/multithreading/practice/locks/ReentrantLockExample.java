package com.java.multithreading.practice.locks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

    //using reentrant lock a thread can acquire the lock multiple times without causing a deadlock.
    //when fairness is set, threads acquire lock on first-come-first-serve-basis
    private final ReentrantLock lock = new ReentrantLock(true);

    public void doWork(){
        lock.lock();
        try {
            //critical section
            System.out.println(Thread.currentThread().getName()+" is working");
            Thread.sleep(3000);
        } catch (InterruptedException e){

        }
        finally {
            System.out.println(Thread.currentThread().getName()+" finished working");
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLockExample reentrantLockExample = new ReentrantLockExample();

        List<Thread> list = new ArrayList<>();
        for (int i=0; i<5; i++){
            list.add(new Thread(reentrantLockExample::doWork));
        }

        for (int i=0; i<5; i++){
            list.get(i).start();
        }
    }

}
