package com.java.hackerrank;

import java.util.*;
public class HighestNoOfUniqueElementsInSubset {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();
        int uniqueCount=-1;
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.addLast(num);
            if(deque.size()==m){
                Set<Integer> set = new HashSet<>(deque);
                int setSize = set.size();
                if(setSize>uniqueCount){
                    uniqueCount=setSize;
                }
                deque.removeFirst();
            }
        }
        System.out.println(uniqueCount);
    }
}




