package com.java.multithreading;

import java.util.ArrayList;
import java.util.List;

class Processor{

    private List<Integer> list = new ArrayList<>();
    private static final Integer UPPER_LIMIT = 5;
    private static final Integer LOWER_LIMIT = 0;
    private final Object lock = new Object();
    private static Integer value = 0;

    public void producer() throws InterruptedException {
        synchronized (lock){
            while (true){
                if(list.size()==UPPER_LIMIT){
                    System.out.println("Waiting for removing items...");
                    lock.wait();
                }else{
                    System.out.println("Adding value: "+value);
                    list.add(value++);
                    lock.notify();
                }
                Thread.sleep(500);
            }
        }
    }

    public void consumer() throws InterruptedException {
        synchronized (lock){
            while (true){
                if(list.size()==LOWER_LIMIT){
                    System.out.println("Waiting for adding items...");
                    value = 0;
                    lock.wait();
                }else{
                    System.out.println("Removing value: "+list.remove(list.size()-1));
                    lock.notify();
                }
                Thread.sleep(500);

            }
        }
    }

}

public class ProducerConsumerExample {
    public static void main(String[] args) {
        Processor p = new Processor();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    p.producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    p.consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }
}
