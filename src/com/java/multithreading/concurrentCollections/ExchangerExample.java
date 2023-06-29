package com.java.multithreading.concurrentCollections;

import java.util.concurrent.Exchanger;

class Incrementer implements Runnable{

    private int count;
    private Exchanger<Integer> exchanger;

    public Incrementer(Exchanger<Integer> exchanger){
        this.exchanger=exchanger;
        count=0;
    }

    @Override
    public void run() {
        while (true){
            try {
                System.out.println("Thread 1:First thread incrementing count to "+ ++count);
                count = exchanger.exchange(count);
                System.out.println("Thread 1:Got exchange value from second thread "+count);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Decrementer implements Runnable{

    private int count;
    private Exchanger<Integer> exchanger;

    public Decrementer(Exchanger<Integer> exchanger){
        this.exchanger=exchanger;
    }

    @Override
    public void run() {
        while(true){
            try {
                System.out.println("Thread 2:Second thread decrementing count to "+ --count);
                count = exchanger.exchange(count);
                System.out.println("Thread 2:Got exchange value from first thread "+count);
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ExchangerExample {
    public static void main(String[] args) {
        Exchanger<Integer> exchanger = new Exchanger<>();

        new Thread(new Incrementer(exchanger)).start();
        new Thread(new Decrementer(exchanger)).start();
    }
}
