package com.java.jdk21VirtualThreads.Futures;

import java.util.concurrent.*;

public class ExecutorCompletionServiceExample {

    public static void main(String[] args) {

        try {
            ExecutorService es = Executors.newFixedThreadPool(3);
            ExecutorCompletionService ecs = new ExecutorCompletionService(es);

            Callable<TaskResult> callable1 = () -> FuturesPlay.doTask("task1",3,false);
            Callable<TaskResult> callable2 = () -> FuturesPlay.doTask("task2",2,false);

            Future<TaskResult> ft1 = ecs.submit(callable1);
            Future<TaskResult> ft2 = ecs.submit(callable2);

            for (int i=0; i<2; i++){

                Future future = ecs.take();

                if(future == ft1){
                    System.out.println(ft1.get());
                }else {
                    System.out.println(ft2.get());
                }
            }
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
