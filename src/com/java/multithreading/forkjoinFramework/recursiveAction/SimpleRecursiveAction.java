package com.java.multithreading.forkjoinFramework.recursiveAction;

import java.util.concurrent.RecursiveAction;

public class SimpleRecursiveAction extends RecursiveAction {

    private int simulatedWork;

    public SimpleRecursiveAction(int simulatedWork){
        this.simulatedWork = simulatedWork;
    }

    @Override
    protected void compute() {
        if(simulatedWork>100){
            System.out.println("Parallel execution and split the tasks... "+simulatedWork);
            SimpleRecursiveAction action1 = new SimpleRecursiveAction(simulatedWork/2);
            SimpleRecursiveAction action2 = new SimpleRecursiveAction(simulatedWork/2);

//            action1.fork();
//            action2.fork();
//            action1.join();
//            action2.join();
//            invokeAll calls all the above methods internally
            invokeAll(action1,action2);
        }
        else{
            System.out.println("Task is small so sequential execution is fine");
            System.out.println("Simulated work is "+simulatedWork);
        }
    }
}
