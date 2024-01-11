package com.java.jdk21VirtualThreads.virtualThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import static java.lang.Thread.Builder.OfVirtual;
public class DiffWaysToCreateVirtualThread {

    public static void main(String[] args) throws Exception {

        System.out.println("starting main thread "+Thread.currentThread());

//        createVirtualThreadUsingFactory();
//        virtualThreadUsingExecutorService();
        virtualThreadUsingFactoryAndExecutorService();
        System.out.println("stopping main thread "+Thread.currentThread());

    }

    public static void createSimpleVirtualThread() throws Exception {

        Thread thread1 =  Thread.startVirtualThread(DiffWaysToCreateVirtualThread::handleUserRequest);
        Thread thread2 =  Thread.startVirtualThread(DiffWaysToCreateVirtualThread::handleUserRequest);
        thread1.join();
        thread2.join();
    }

    public static void createVirtualThreadUsingBuilder() throws Exception {
        //builder is not thread safe
        OfVirtual vtBuilder = Thread.ofVirtual().name("user-thread",1);

        Thread t1 = vtBuilder.start(DiffWaysToCreateVirtualThread::handleUserRequest);
        Thread t2 = vtBuilder.start(DiffWaysToCreateVirtualThread::handleUserRequest);

        t1.join();
        t2.join();
    }

    public static void createVirtualThreadUsingFactory() throws Exception {
        //factory is thread safe
        ThreadFactory vtFactory = Thread.ofVirtual().name("user-thread",1).factory();

        Thread t1 = vtFactory.newThread(DiffWaysToCreateVirtualThread::handleUserRequest);
        t1.start();
        Thread t2 = vtFactory.newThread(DiffWaysToCreateVirtualThread::handleUserRequest);
        t2.start();

        t1.join();
        t2.join();
    }

    public static void virtualThreadUsingExecutorService() throws Exception{
//        ExecutorService extends AutoClosable
//        no need to call join
//        waits for all virtual threads to complete
        try(ExecutorService es = Executors.newVirtualThreadPerTaskExecutor()) {
            es.submit(DiffWaysToCreateVirtualThread::handleUserRequest);
            es.submit(DiffWaysToCreateVirtualThread::handleUserRequest);
        }
    }

    private static void virtualThreadUsingFactoryAndExecutorService() throws Exception{

        ThreadFactory factory = Thread.ofVirtual().name("user-thread").factory();

        try(ExecutorService es = Executors.newThreadPerTaskExecutor(factory)) {
            es.submit(DiffWaysToCreateVirtualThread::handleUserRequest);
            es.submit(DiffWaysToCreateVirtualThread::handleUserRequest);
        }
    }

    private static void handleUserRequest() {
        System.out.println("starting handleUserRequest thread "+Thread.currentThread());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("stopping handleUserRequest thread "+Thread.currentThread());
    }
}
