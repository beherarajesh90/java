package com.java.dsa.heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class HeapInJava {
    public static void main(String[] args) {
        //MAX HEAP
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        //MIN HEAP
//        Queue<Integer> minHeap = new PriorityQueue<>();

        maxHeap.add(10);
        maxHeap.add(30);
        maxHeap.add(20);
        maxHeap.add(5);
        maxHeap.add(1);

        while (!maxHeap.isEmpty()){
            System.out.print(maxHeap.peek()+" ");
            //remove
            maxHeap.poll();
        }
    }
}
