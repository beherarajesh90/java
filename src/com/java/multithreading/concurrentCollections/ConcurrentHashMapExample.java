package com.java.multithreading.concurrentCollections;

import java.util.concurrent.ConcurrentHashMap;

class ConcurrentWorker1 implements Runnable{

    private ConcurrentHashMap<String,Integer> map;

    public ConcurrentWorker1(ConcurrentHashMap<String,Integer> map){
        this.map = map;
    }

    @Override
    public void run() {
        System.out.println("Adding into the map");
        map.put("B",2);
        map.put("A",6);
        map.put("D",5);
        map.put("E",9);
    }
}

class ConcurrentWorker2 implements Runnable{

    private ConcurrentHashMap<String,Integer> map;

    public ConcurrentWorker2(ConcurrentHashMap<String,Integer> map){
        this.map = map;
    }

    @Override
    public void run() {
        try {

            System.out.println("Getting elements from the map");
        System.out.println(map.get("A"));
            Thread.sleep(2000);

        System.out.println(map.get("D"));
        Thread.sleep(2000);
        System.out.println(map.get("E"));
        Thread.sleep(2000);
        System.out.println(map.get("B"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ConcurrentHashMapExample {
    public static void main(String[] args) {
        ConcurrentHashMap<String,Integer> map = new ConcurrentHashMap<>();

        ConcurrentWorker1 worker1 = new ConcurrentWorker1(map);
        ConcurrentWorker2 worker2 = new ConcurrentWorker2(map);

        new Thread(worker1).start();
        new Thread(worker2).start();
    }
}
