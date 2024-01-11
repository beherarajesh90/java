package com.java.jdk21VirtualThreads.Futures;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RunnableExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        System.out.println("Started main thread");
        ExecutorService es = Executors.newSingleThreadExecutor();
        Runnable task = ()->{
            System.out.printf("%s : Starting simple task\n", Thread.currentThread().getName());

            try {
                Thread.sleep(3000);
            }catch (InterruptedException ex){
                System.out.println("task interrupted");
            }

            System.out.printf("%s : Ending simple task\n", Thread.currentThread().getName());

        };
        Future<?> future = es.submit(task);
        future.get();
        System.out.println("Ended main thread");
    }

}
