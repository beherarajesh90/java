package com.java.multithreading;

class WorkerThread implements Runnable{

    @Override
    public void run() {
        for (int i=0;i<10;i++){
            System.out.println(i);
        }
    }
}

public class ThreadPriorityExample {
    public static void main(String[] args) {
        Thread t1 = new Thread(new WorkerThread());
        t1.setPriority(1);
        t1.start();
        //by default priority is 5
        System.out.println("Main Thread Running with priority "+Thread.currentThread().getPriority());
    }
}
