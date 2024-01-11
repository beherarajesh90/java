package com.java.jdk21VirtualThreads.Futures;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class CompletableFutureExample {
    public static void main(String[] args) {
        Supplier<TaskResult> task1 = () -> FuturesPlay.doTask("task1", 4, false);
        Supplier<TaskResult> task2 = () -> FuturesPlay.doTask("task2", 2, false);

        CompletableFuture<Void> cf = CompletableFuture.supplyAsync(task1).thenCombine(CompletableFuture.supplyAsync(task2),
                (t1, t2) -> String.format("combined result of %s %s", t1.getName(), t2.getName()))
                .exceptionally(ex -> {
                    System.out.println("exception: "+ex.getMessage());
                    return "exception handled";
                })
                .thenApply(data -> data + " : handled apply")
                .thenAccept(data -> {
                    System.out.println(data + " : handled accept");
        });

        cf.join();



//        try {
//            Thread.sleep(6000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        System.out.println("All tasks completed");
    }
}
