package com.java.dsa.deque;

class Deque{
    private static final int MAX_SIZE = 100;
    private int arr[];
    private int front;
    private int rear;
    private int size;

    Deque(int size){
        this.size = size;
        arr = new int[MAX_SIZE];
        rear = 0;
        front = rear;
    }

    public boolean isEmpty(){
        return (rear == 0);
    }

//    public boolean isFull(){
//
//    }
}
public class CircularDequeImplementation {

}
