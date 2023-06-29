package com.java.multithreading.concurrentCollections;

import java.util.Comparator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

class Worker1 implements Runnable{

    private BlockingQueue<Person> queue;

    public Worker1(BlockingQueue<Person> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            System.out.println("Putting items into the queue");
            queue.put(new Person("Rajesh",23));
            queue.put(new Person("Aniket",22));
            queue.put(new Person("Mahesh",22));
            queue.put(new Person("Charan",21));
            queue.put(new Person("Harshith",20));
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Worker2 implements Runnable{

    private BlockingQueue<Person> queue;

    public Worker2(BlockingQueue<Person> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            System.out.println("Removing items from the queue");
            System.out.println(queue.take());
            Thread.sleep(1000);
            System.out.println(queue.take());
            System.out.println(queue.take());
            Thread.sleep(2000);
            System.out.println(queue.take());
            System.out.println(queue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Person implements Comparable<Person>{

    private String name;
    private int age;

    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person other) {
        return name.compareTo(other.getName());
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class PriortyBlockingQueueExample {
    public static void main(String[] args) {
        BlockingQueue<Person> bq = new PriorityBlockingQueue<>();

        Worker1 w1 = new Worker1(bq);
        Worker2 w2 = new Worker2(bq);

        new Thread(w1).start();
        new Thread(w2).start();
    }
}
