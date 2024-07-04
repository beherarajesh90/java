package com.java.jdk21VirtualThreads.httpBinOrgExample;

import java.util.Arrays;
import java.util.concurrent.*;
import java.util.stream.Collectors;

@SuppressWarnings("preview")
public class UserRequestHandler implements Callable<String> {

    @Override
    public String call() throws Exception {
        return concurrentCallCompletableFuture();
    }

    private String concurrentCallCompletableFuture() throws Exception {
        try (ExecutorService service = Executors.newVirtualThreadPerTaskExecutor()) {

            String output = CompletableFuture
                    .supplyAsync(this::dbCall, service)
                    .thenCombine(
                            CompletableFuture.supplyAsync(this::restCall, service)
                            , (result1, result2) -> {
                                return "[" + result1 + "," + result2 + "]";
                            })
                    .thenApply(result -> {

                        // both dbCall and restCall have completed
                        String r = externalCall();
                        return "[" + result + "," + r + "]";

                    })
                    .join();

            System.out.println(output);
            return output;

        }
    }

    private String concurrentCallReactiveStyle() throws Exception {
        long start = System.currentTimeMillis();
        try(ExecutorService es = Executors.newVirtualThreadPerTaskExecutor()) {
            String result = es.invokeAll(Arrays.asList(this::dbCall,this::restCall))
                    .stream().map( task -> {
                        try {
                            return (String) task.get();
                        } catch (Exception e){
                            return null;
                        }
                    })
                    .collect(Collectors.joining(","));
            System.out.println(result);
            long end = System.currentTimeMillis();
            System.out.println("Duration: "+(end-start));
            return String.format("[ %s ]", result);
        }

    }
    private String concurrentCallWithFutures() throws Exception {
        long start = System.currentTimeMillis();
        try(ExecutorService es = Executors.newVirtualThreadPerTaskExecutor()) {
            Future<String> result1 = es.submit(this::dbCall);
            Future<String> result2 =  es.submit(this::restCall);
            System.out.println(result1.get() + "\n" + result2.get());
            long end = System.currentTimeMillis();
            System.out.println("Duration: "+(end-start));
            return String.format("[%s , %s]", result1, result2);
        }

    }

    private String sequentialCall() throws Exception {
        long start = System.currentTimeMillis();

        String result1 = dbCall();
        String result2 = restCall();

        System.out.println(result1 + "\n" + result2);
        long end = System.currentTimeMillis();

        System.out.println("Duration: "+(end-start));
        return String.format("[%s , %s]", result1, result2);
    }

    private String dbCall() {
//        System.out.println("Making db network call: "+Thread.currentThread());
        NetworkCaller networkCaller = new NetworkCaller("dbCall");
        try {
            return networkCaller.makeCall(2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String restCall() {
//        System.out.println("Making rest network call: "+Thread.currentThread());
        NetworkCaller networkCaller = new NetworkCaller("rest");
        try {
            return networkCaller.makeCall(5);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String externalCall() {
//        System.out.println("Making rest network call: "+Thread.currentThread());
        NetworkCaller networkCaller = new NetworkCaller("extCall");
        try {
            return networkCaller.makeCall(3);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
