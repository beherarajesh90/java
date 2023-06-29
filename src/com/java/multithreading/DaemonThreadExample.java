package com.java.multithreading;

class DaemonWorker implements Runnable{

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Daemon worker is running "+Thread.currentThread().getName());
        }
    }
}

class NormalWorker implements Runnable{

    @Override
    public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Normal worker is running "+Thread.currentThread().getName());
    }
}

public class DaemonThreadExample {
    public static void main(String[] args) {
        Thread t1 = new Thread(new DaemonWorker());
        Thread t2 = new Thread(new NormalWorker());

        //setting t1 thread as daemon thread
        t1.setDaemon(true);

        //DaemonWorker runs until all the NormalWorkers are terminated
        //JVM terminates the daemon thread
        t1.start();
        t2.start();
        System.out.println(Thread.currentThread().getName()+" thread");

    }
}
