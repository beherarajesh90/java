package com.java.dsa.deque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class DequeExample {
    public static void main(String[] args) {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.addLast(1);
        dq.addLast(2);
        dq.addFirst(3);
        dq.addFirst(4);
        Iterator<Integer> itr = dq.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
