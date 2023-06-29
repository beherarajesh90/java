package com.java.multithreading.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Work implements Runnable{

    private Integer id;

    public Work(Integer id){
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Running task with "+id+" by thread "+Thread.currentThread().getName());
        long duration =(long) (Math.random()*5);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class FixedThreadPoolExecutorExample {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(4);
        for (int i = 0; i<10;i++){
            es.execute(new Work(i));
        }
        //stops executing further tasks
        es.shutdown();

        //terminates actual running tasks
        try {
            if(!es.awaitTermination(5000,TimeUnit.MILLISECONDS)){
                es.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
