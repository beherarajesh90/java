package com.java.multithreading.concurrentCollections;

import java.util.concurrent.*;

class DelayedWorker implements Delayed{

    private String message;
    private long duration;

    public DelayedWorker(String message,long duration){
        this.message = message;
        this.duration = System.currentTimeMillis()+duration;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(duration-System.currentTimeMillis(),TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        if(duration < ((DelayedWorker) o).getDuration()){
            return -1;
        }
        if(duration > ((DelayedWorker) o).getDuration()){
            return 1;
        }
        return 0;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "DelayedWorker{" +
                "message='" + message + '\'' +
                '}';
    }
}

public class DelayedQueueExample {
    public static void main(String[] args) {
        BlockingQueue<DelayedWorker> bq = new DelayQueue<>();
        try {
            bq.put(new DelayedWorker("First message ...",2000));
            bq.put(new DelayedWorker("Second message ...",10000));
            bq.put(new DelayedWorker("Third message ...",4500));
            bq.put(new DelayedWorker("Fourth message ...",3000));
            bq.put(new DelayedWorker("Fifth message ...",8000));
            bq.put(new DelayedWorker("Sixth message ...",5500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ExecutorService service = Executors.newFixedThreadPool(3);
        while (!bq.isEmpty()){
            service.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("Pulling "+bq.take()+" from queue by"+Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        service.shutdown();
    }
}
