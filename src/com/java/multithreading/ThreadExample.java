package com.java.multithreading;

class Runner3 extends Thread{

    @Override
    public void run() {
        for(int i=0;i<10;i++)
            System.out.println("thread 1 "+ i);
    }
}
class Runner4 extends Thread {

    @Override
    public void run() {
        for(int i=0;i<10;i++)
            System.out.println("thread 2 "+ i);
    }
}
public class ThreadExample {
    public static void main(String[] args) {
        Thread t1 = new Runner3();
        Thread t2 = new Runner4();
        t1.start();
        t2.start();
    }
}
