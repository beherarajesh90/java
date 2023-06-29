package com.java.multithreading.concurrentCollections;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class FirstWorker implements Runnable{

    private Integer count;
    private BlockingQueue<Integer> bq;

    public FirstWorker(BlockingQueue<Integer> bq){
        this.bq=bq;
        count=0;
    }

    @Override
    public void run() {
        while(true){
            try {
                bq.put(count);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Pushing into the queue "+count);
            count++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class SecondWorker implements Runnable{

    private BlockingQueue<Integer> bq;

    public SecondWorker(BlockingQueue<Integer> bq){
        this.bq=bq;
    }

    @Override
    public void run() {
        while(true){
            try {
                Integer i = bq.take();
                System.out.println("Removing from the queue "+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(300 );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class BlockingQueueExample {
    public static void main(String[] args) {
        BlockingQueue<Integer> bq = new ArrayBlockingQueue<>(10);
        new Thread(new FirstWorker(bq)).start();
        new Thread(new SecondWorker(bq)).start();
    }
}
