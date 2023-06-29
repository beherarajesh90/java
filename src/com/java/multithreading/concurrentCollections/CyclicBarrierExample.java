package com.java.multithreading.concurrentCollections;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class BarrierWorker implements Runnable{

    private int id;
    private Random random;
    private CyclicBarrier cyclicBarrier;

    public BarrierWorker(int id,CyclicBarrier cyclicBarrier){
        this.id=id;
        this.cyclicBarrier=cyclicBarrier;
        random = new Random();
    }

    @Override
    public void run() {
        doWork();
    }

    private void doWork() {
        System.out.println("Worker "+id+" started by thread "+Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("after await of worker "+id);
    }
}

public class CyclicBarrierExample {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("All tasks finished");
            }
        });
        ExecutorService service = Executors.newFixedThreadPool(5);
        for(int i=0;i<5;i++){
            service.execute(new BarrierWorker(i+1,cyclicBarrier));
        }
        service.shutdown();
    }
}
