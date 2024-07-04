package com.java.multithreading.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class StockUpdates implements Runnable{

    @Override
    public void run() {
        System.out.println("updating stock data .. ... . by "+Thread.currentThread().getName());
    }
}

public class StockMarketExecutorExample {
    public static void main(String[] args) {
        ScheduledExecutorService es = Executors.newScheduledThreadPool(1);
        es.scheduleAtFixedRate(new StockUpdates(),1000,3000, TimeUnit.MILLISECONDS);
    }
}
