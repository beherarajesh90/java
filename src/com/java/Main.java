package com.java;

import java.lang.*;
import java.util.*;
//import java.util.*;


class Main {
    public static void main(String[] args) {

//        int n = 25, firstTerm = 0, secondTerm = 1;
//        System.out.println("Fibonacci Series till " + n + " terms:");
//
//        for (int i = 1; i <= n; ++i) {
//            System.out.print(firstTerm + ", ");
//
//            // compute the next term
//            int nextTerm = firstTerm + secondTerm;
//            firstTerm = secondTerm;
//            secondTerm = nextTerm;
//        }
        Queue<Integer> q1 = new LinkedList<>();
        q1.add(1);
        q1.add(2);
        q1.add(3);
        q1.poll();
        for(Integer ele:q1){
            System.out.println(ele);
        }
        Stack<Integer> st = new Stack<>();
        st.add(1);
        st.add(2);
        st.add(3);
        for(int i:st){
            System.out.println(i);
        }
    }
}
