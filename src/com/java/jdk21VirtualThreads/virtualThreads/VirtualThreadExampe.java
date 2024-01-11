package com.java.jdk21VirtualThreads.virtualThreads;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class VirtualThreadExampe {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("starting main thread "+Thread.currentThread());

        var threads = new ArrayList<Thread>();
        IntStream.range(0,100000).forEach((i)->{
            threads.add(startThread());
        });

        for (Thread thread : threads){
            thread.join();
        }

        System.out.println("stopping main thread "+Thread.currentThread());
    }

//    @SuppressWarnings("preview")
    private static Thread startThread() {
//        new Thread(VirtualThreadExampe::handleUserRequest).start();
        return Thread.startVirtualThread(VirtualThreadExampe::handleUserRequest);
    }

    private static void handleUserRequest() {
        System.out.println("starting handleUserRequest thread "+Thread.currentThread());

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("stopping handleUserRequest thread "+Thread.currentThread());
    }

}
