package com.java.dsa.queues;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {

    //stack push operation costly
//    static class Stack{
//
//        static Queue<Integer> q1 = new LinkedList<>();
//        static Queue<Integer> q2 = new LinkedList<>();
//
//        static int cur_size;
//
//        Stack(){
//            cur_size = 0;
//        }
//
//        static void push(int x){
//            //increase the size of stack
//            cur_size++;
//
//            //add the element into queue2
//            q2.add(x);
//
//            //push all the elements from q1 to q2
//            while (!q1.isEmpty()){
//                q2.add(q1.peek());
//                q1.remove();
//            }
//
//            //swap the names of the queues
//            Queue<Integer> q = q2;
//            q2 = q1;
//            q1 = q;
//        }
//
//        static Integer pop(){
//            if(q1.isEmpty()){
//                return -1;
//            }
//            cur_size--;
//            return q1.remove();
//        }
//
//        static Integer top(){
//            if (q1.isEmpty()){
//                return -1;
//            }
//            return q1.peek();
//        }
//
//        static Integer size(){
//            return cur_size;
//        }
//    }

    //stack pop operation costly
    static class Stack{

        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        static int cur_size;

        Stack(){
            cur_size = 0;
        }

        static void push(int x){
            q1.add(x);
            cur_size++;
        }

        static Integer pop(){

            if(cur_size==0){
                return -1;
            }

            while (q1.size()!=1){
                q2.add(q1.remove());
            }

            cur_size--;
            Integer temp = q1.remove();
            Queue<Integer> q = q1;
            q1 = q2;
            q2 = q;
            return temp;
        }

        static Integer top(){
            if (q1.isEmpty()){
                return -1;
            }

            while (q1.size()!=1){
                q2.add(q1.remove());
            }

            Integer temp = q1.peek();
            q2.add(q1.remove());
            Queue<Integer> q = q1;
            q1 = q2;
            q2 = q;
            return temp;
        }

        static Integer size(){
            return cur_size;
        }
    }

    public static void main(String args[]){
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Popping "+stack.pop());
        stack.push(4);
        stack.push(5);
        System.out.println("Top element "+stack.top());
        System.out.println("Popping "+stack.pop());

    }
}
