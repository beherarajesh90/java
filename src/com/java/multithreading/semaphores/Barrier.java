package com.java.multithreading.semaphores;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Barrier {

    private final int noOfWorkers;
    private final Semaphore semaphore = new Semaphore(0);
    private int count = 0;
    private final Lock lock = new ReentrantLock();

    public Barrier(int noOfWorkers){
        this.noOfWorkers = noOfWorkers;
    }

    public void waitForOthers() throws InterruptedException {
        lock.lock();
        boolean isLastWorker = false;
        try {
            count++;
            if (count == noOfWorkers)
                isLastWorker = true;
        }finally {
            lock.unlock();
        }
        if (isLastWorker)
            semaphore.release(noOfWorkers - 1);
        else
            semaphore.acquire();
    }
}
class CoordinatedWorkerRunner implements Runnable{

    private final Barrier barrier;

    public CoordinatedWorkerRunner(Barrier barrier){
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            task();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void task() throws InterruptedException {
        // Performing Part 1
        System.out.println(Thread.currentThread().getName()
                + " part 1 of the work is finished");

        barrier.waitForOthers();

        // Performing Part2
        System.out.println(Thread.currentThread().getName()
                + " part 2 of the work is finished");
    }

    public static void main(String[] args) {

        int noOfThreads = 10;
        List<Thread> threadList = new ArrayList<>(noOfThreads);
        Barrier barrier = new Barrier(noOfThreads);
        for(int i=0; i<noOfThreads; i++){
            threadList.add(new Thread(new CoordinatedWorkerRunner(barrier)));
        }
        for(Thread thread: threadList){
            thread.start();
        }
    }
}
