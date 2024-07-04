package com.java.jdk21VirtualThreads.httpBinOrgExample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.IntStream;

public class HttpPlayer {

    private static final int NO_OF_USERS = 1;
    public static void main(String[] args) {
        ThreadFactory threadFactory = Thread.ofVirtual().name("request-handler", 0).factory();
        try(ExecutorService executorService = Executors.newThreadPerTaskExecutor(threadFactory)) {

            IntStream.range(0,NO_OF_USERS).forEach(user -> {

                executorService.submit(new UserRequestHandler());
            });
        }
    }
}
