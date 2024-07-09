package com.java.multithreading.practice.locks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.StampedLock;

public class StampedLockExample {

//    It provides an advanced lock mechanism with three modes: writing, reading, and optimistic reading.
    private final StampedLock stampedLock = new StampedLock();
    private int value = 0;

    public void readValue(){
        while (true){

            long stamp = stampedLock.tryOptimisticRead();
            if(!stampedLock.validate(stamp)){
                stamp = stampedLock.readLock();
                try {
                    System.out.printf("reading value:%s by thread:%s \n", value, Thread.currentThread().getName());
                    Thread.sleep(2000);
                } catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                    break;
                }
                finally {
                    System.out.printf("reading complete by thread:%s \n", Thread.currentThread().getName());
                    stampedLock.unlockRead(stamp);
                }
            }

        }

    }

    public void writeValue(){
        long stamp = stampedLock.writeLock();
        try {
            if(value==1) throw new RuntimeException("errorr");
            value+=1;
            System.out.printf("writing value:%s by thread:%s \n", value, Thread.currentThread().getName());
            Thread.sleep(2000);
        } catch (Exception ex){
            value++;
            Thread.currentThread().interrupt();
        }
        finally {
            System.out.printf("writing complete by thread:%s \n", Thread.currentThread().getName());
            stampedLock.unlockWrite(stamp);
        }
    }

    public static void main(String[] args) {
        StampedLockExample stampedLock = new StampedLockExample();
        List<Thread> readerThreads = new ArrayList<>();
        List<Thread> writerThreads = new ArrayList<>();
        for (int i=0; i<3; i++){
            readerThreads.add(new Thread(stampedLock::readValue, "readerThread-"+i));
            writerThreads.add(new Thread(stampedLock::writeValue, "writerThread-"+i));
        }

        for (int i=0; i<3; i++){
            readerThreads.get(i).start();
        }

        for (int i=0; i<3; i++){
            writerThreads.get(i).start();
        }


    }
}
