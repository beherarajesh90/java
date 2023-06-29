package com.java.multithreading;

class Runner1 implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<10;i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread 1 " + i);
        }
    }
}
class Runner2 implements Runnable {

    @Override
    public void run() {
        for(int i=0;i<10;i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread 2 " + i);
        }
    }
}
public class RunnableExample {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runner1());
        Thread t2 = new Thread(new Runner2());
        t1.start();
        t2.start();
        try {
            t1.join(); //wait for t1 to execute
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("******hello******"); //this line waits for t1 as join is mentioned
    }
}



//public class RunnableExample {
//    public static void main(String[] args) {
//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for(int i=0;i<10;i++)
//                    System.out.println("thread 1 "+ i);
//            }
//        });
//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for(int i=0;i<10;i++)
//                    System.out.println("thread 2 "+ i);
//            }
//        });
//
//        t1.start();
//        t2.start();
//    }
//}
