package com.java.dsa.stacks.implementations;

import java.util.Stack;

public class MinStack {

    Stack<Node> stack;

    class Node{
        private int value;
        private int min;
        Node(int value,int min){
            this.value=value;
            this.min=min;
        }
    }

    MinStack(){
        stack = new Stack<>();
    }

    public void push(int value){
        if(stack.isEmpty()){
            stack.push(new Node(value,value));
        }
        else{
            int min = Math.min(stack.peek().value,value);
            stack.push(new Node(value,min));
        }
    }
    public int pop(){
        return stack.pop().value;
    }
    public int peek(){
        return stack.peek().value;
    }
    public int getMin(){
        return stack.peek().min;
    }

    public static void main(String[] args) {
        MinStack s = new MinStack();

        // Function calls
        s.push(-1);
        s.push(10);
        s.push(-4);
        s.push(0);
        System.out.println(s.getMin());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.getMin());
    }
}
