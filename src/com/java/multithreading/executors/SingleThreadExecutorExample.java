package com.java.multithreading.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Task implements Runnable{

    private Integer id;

    public Task(Integer id){
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Running task with "+id+" by thread "+Thread.currentThread().getName());
        long duration =(long) (Math.random()*5);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class SingleThreadExecutorExample {
    public static void main(String[] args) {
        ExecutorService es = Executors.newSingleThreadExecutor();
        for (int i = 0; i<10;i++){
            es.execute(new Task(i));
        }
    }
}
