package com.java.jdk21VirtualThreads.Futures;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class TaskResult{
    private final String name;
    private final int seconds;

    public TaskResult(String name, int seconds) {
        this.name = name;
        this.seconds = seconds;
    }

    public String getName() {
        return name;
    }

    public int getSeconds() {
        return seconds;
    }
}

class FuturesPlay{

    public static TaskResult doTask(String name,int secs,boolean fail){
        System.out.printf("%s : task started\n", Thread.currentThread().getName());

        try {
            Thread.sleep(3000);
        }catch (InterruptedException ex){
            throw new RuntimeException("exception occured");
        }

        if(fail){
            throw new RuntimeException("exception invoke explicitly");
        }

        System.out.printf("%s : task completed\n", Thread.currentThread().getName());
        return new TaskResult(name,secs);
    }
}
public class CallableExample {

    public static void main(String[] args) {

        ExecutorService es = Executors.newFixedThreadPool(3);

        try {
            Future<TaskResult> future = es.submit(() -> FuturesPlay.doTask("subtask-1", 3, false));
            Future<TaskResult> future2 = es.submit(() -> FuturesPlay.doTask("subtask-2", 1, true));
            Future<TaskResult> future3 = es.submit(() -> FuturesPlay.doTask("subtask-3", 2, false));

            TaskResult result = future.get();
            System.out.println("task 1"+result);
            TaskResult result2 = future.get();
            System.out.println("task 2"+result);
            TaskResult result3 = future.get();
            System.out.println("task 3"+result);

        } catch (ExecutionException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
