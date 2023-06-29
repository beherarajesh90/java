package com.java.dsa.stacks.implementations;

public class StackImplementationUsingArray {

    static final int MAX = 1000;
    int top;
    int arr[] = new int[MAX];

    StackImplementationUsingArray(){
        top=-1;
    }

    public boolean isEmpty(){
        return top<0;
    }

    public int push(int x){
        if(top>MAX-1){
            System.out.println("Stack overflow");
            return -1;
        }
        else{
            arr[++top]=x;
            System.out.printf("Pushed %s to stack\n",x);
            return x;
        }
    }

    public int pop(){
        if(top<=-1){
            System.out.println("Stack underflow");
            return -1;
        }
        else{
            int ele = arr[top--];
            return ele;
        }
    }

    public int peek(){
        if(top<0){
            System.out.println("Stack underflow");
            return -1;
        }
        else{
            System.out.println("top element is "+arr[top]);
            return arr[top];
        }
    }

    public int size(){
        return top+1;
    }

    public void print(){
        for(int i=0;i<=top;i++){
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        StackImplementationUsingArray stack = new StackImplementationUsingArray();
        stack.push(45);
        stack.push(9);
        stack.push(90);
        stack.pop();
        stack.push(46);
        stack.push(49);
        stack.pop();
        stack.print();
        stack.peek();
        System.out.println("Size of stack is "+stack.size());

    }
}
