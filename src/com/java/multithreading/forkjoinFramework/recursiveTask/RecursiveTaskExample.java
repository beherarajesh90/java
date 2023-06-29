package com.java.multithreading.forkjoinFramework.recursiveTask;

import java.util.concurrent.RecursiveTask;

public class RecursiveTaskExample extends RecursiveTask<Double> {

    private double simulatedWork;

    public RecursiveTaskExample(double simulatedWork){
        this.simulatedWork = simulatedWork;
    }

    @Override
    protected Double compute() {
        if(simulatedWork>1000){
            System.out.println("Using parallel approach -> splitting into subtasks "+simulatedWork);
            RecursiveTaskExample action1 = new RecursiveTaskExample(simulatedWork/2);
            RecursiveTaskExample action2 = new RecursiveTaskExample(simulatedWork/2);

            action1.fork();
            action2.fork();

            double partialSum = 0;
            partialSum+=action1.join();
            partialSum+=action2.join();
            return partialSum;
        }
        System.out.println("Using sequential approach "+simulatedWork);
        return 2*simulatedWork;
    }

}
