package com.java.multithreading.multithreadingConcepts;

class VolatileWorker implements Runnable{

    private volatile boolean terminated;

    public boolean isTerminated() {
        return terminated;
    }

    public void setTerminated(boolean terminated) {
        this.terminated = terminated;
    }

    @Override
    public void run() {
        while (!terminated){
            System.out.println("Worker class in running...");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class VolatileKeywordExample2 {
    public static void main(String[] args) {
        VolatileWorker v = new VolatileWorker();
        Thread t1 = new Thread(v);
        t1.start();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        v.setTerminated(true);
        System.out.println("Terminated");
    }
}
