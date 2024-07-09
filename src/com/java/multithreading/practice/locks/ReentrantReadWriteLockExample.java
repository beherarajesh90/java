package com.java.multithreading.practice.locks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockExample {

//    Optimized for scenarios with frequent reads and infrequent writes.
    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    private int value = 0;

    public void readValue(){
        rwLock.readLock().lock();
        try {
            System.out.printf("reading value:%s by thread:%s \n", value, Thread.currentThread().getName());
            Thread.sleep(2000);
        } catch (InterruptedException e){

        }
        finally {
            System.out.printf("reading complete by thread:%s \n", Thread.currentThread().getName());
            rwLock.readLock().unlock();
        }
    }

    public void writeValue(){
        rwLock.writeLock().lock();
        try {
            value+=1;
            System.out.printf("writing value:%s by thread:%s \n", value, Thread.currentThread().getName());
            Thread.sleep(2000);
        } catch (InterruptedException e){

        }
        finally {
            System.out.printf("writing complete by thread:%s \n", Thread.currentThread().getName());
            rwLock.writeLock().unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantReadWriteLockExample reentrantReadWriteLockExample = new ReentrantReadWriteLockExample();
        List<Thread> readerThreads = new ArrayList<>();
        List<Thread> writerThreads = new ArrayList<>();
        for (int i=0; i<5; i++){
            readerThreads.add(new Thread(reentrantReadWriteLockExample::readValue, "readerThread-"+i));
            writerThreads.add(new Thread(reentrantReadWriteLockExample::writeValue, "writerThread-"+i));
        }
        readerThreads.get(0).start();
        writerThreads.get(0).start();
        writerThreads.get(1).start();
        writerThreads.get(2).start();
        readerThreads.get(1).start();
        readerThreads.get(2).start();
    }
}
