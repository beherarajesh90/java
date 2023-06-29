package com.java.dsa.queues;

import java.util.Arrays;

class Queue {

    private int front,rear,size,capacity,arr[];

    public Queue(int capacity){
        this.capacity = capacity;
        this.size=0;
        rear = front = -1;
        arr = new int[capacity];
    }

    boolean isFull(Queue queue){
        return (queue.size == queue.capacity);
    }

    boolean isEmpty(Queue queue){
        return (queue.size == 0);
    }

    void enque(int item){
        if(isFull(this)){
            System.out.println("Queue is full. Cannot add item to the queue");
            return;
        }
        if(rear == -1){
            front = 0;
        }
        rear = (rear+1) % capacity;
        arr[rear] = item;
        size++;
        System.out.println("added to the queue");
    }

    int deque(){
        if(isEmpty(this)){
            System.out.println("Queue is empty. Cannot deque from empty queue");
            return -1;
        }
        int item = arr[front];
        front = ( front + 1 ) % capacity;
        size--;
        return item;
    }

    int getFront(){
        if(isEmpty(this)){
            return Integer.MIN_VALUE;
        }
        return arr[front];
    }

    int getRear(){
        if(isEmpty(this)){
            return Integer.MAX_VALUE;
        }
        return arr[rear];
    }

    void printQueue(){
        Arrays.stream(arr).forEach(item -> System.out.println(item));
    }
}
public class QueueExample{
    public static void main(String[] args) {
        Queue q = new Queue(10);
        q.enque(1);
        q.enque(2);
        q.enque(3);
        q.deque();
        q.enque(12);
        q.enque(21);
        q.enque(33);
        q.enque(14);
        q.enque(25);
        q.enque(36);
        q.enque(17);
        q.enque(28);
        q.printQueue();
    }
}